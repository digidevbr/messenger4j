package br.com.digidev.receive;

import br.com.digidev.exceptions.MessengerVerificationException;
import br.com.digidev.internal.JsonHelper;
import br.com.digidev.internal.PreConditions;
import br.com.digidev.receive.callers.MessageDeliveredEventHandlerCaller;
import br.com.digidev.receive.handlers.FallbackEventHandler;
import br.com.digidev.receive.callers.AccountLinkingEventHandlerCaller;
import br.com.digidev.receive.callers.AttachmentMessageEventHandlerCaller;
import br.com.digidev.receive.callers.EchoMessageEventHandlerCaller;
import br.com.digidev.receive.callers.EventHandlerCaller;
import br.com.digidev.receive.callers.MessageReadEventHandlerCaller;
import br.com.digidev.receive.callers.OptInEventHandlerCaller;
import br.com.digidev.receive.callers.PostbackEventHandlerCaller;
import br.com.digidev.receive.callers.QuickReplyMessageEventHandlerCaller;
import br.com.digidev.receive.callers.TextMessageEventHandlerCaller;
import br.com.digidev.receive.events.FallbackEvent;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is the standard implementation of the {@link MessengerReceiveClient} interface used by
 * the {@link MessengerReceiveClientBuilder}.
 *
 * @author Max Grabenhorst
 * @since 0.6.0
 * @see MessengerReceiveClient
 */
final class MessengerReceiveClientImpl implements MessengerReceiveClient {

    private static final String OBJECT_TYPE_PAGE = "page";
    private static final String HUB_MODE_SUBSCRIBE = "subscribe";

    private final Logger logger = LoggerFactory.getLogger(MessengerReceiveClientImpl.class);

    private final String appSecret;
    private final String verifyToken;
    private final boolean disableSignatureVerification;
    private final FallbackEventHandler fallbackEventHandler;

    private final JsonParser jsonParser;
    private final List<EventHandlerCaller> eventHandlerCallers;

    /**
     * Constructs a {@code MessengerReceiveClientImpl} from the values
     * provided by the given {@code MessengerReceiveClientBuilder}
     *
     * @param builder a {@code MessengerReceiveClientBuilder}
     */
    MessengerReceiveClientImpl(MessengerReceiveClientBuilder builder) {
        this.appSecret = builder.appSecret;
        this.verifyToken = builder.verifyToken;
        this.disableSignatureVerification = builder.disableSignatureVerification;
        this.fallbackEventHandler = builder.fallbackEventHandler;

        this.jsonParser = new JsonParser();
        this.eventHandlerCallers = new ArrayList<>(9);

        registerEventHandlerCaller(new TextMessageEventHandlerCaller(builder.textMessageEventHandler,
                builder.fallbackEventHandler));
        registerEventHandlerCaller(new AttachmentMessageEventHandlerCaller(builder.attachmentMessageEventHandler,
                builder.fallbackEventHandler));
        registerEventHandlerCaller(new QuickReplyMessageEventHandlerCaller(builder.quickReplyMessageEventHandler,
                builder.fallbackEventHandler));
        registerEventHandlerCaller(new PostbackEventHandlerCaller(builder.postbackEventHandler,
                builder.fallbackEventHandler));
        registerEventHandlerCaller(new EchoMessageEventHandlerCaller(builder.echoMessageEventHandler,
                builder.fallbackEventHandler));
        registerEventHandlerCaller(new MessageDeliveredEventHandlerCaller(builder.messageDeliveredEventHandler,
                builder.fallbackEventHandler));
        registerEventHandlerCaller(new MessageReadEventHandlerCaller(builder.messageReadEventHandler,
                builder.fallbackEventHandler));
        registerEventHandlerCaller(new AccountLinkingEventHandlerCaller(builder.accountLinkingEventHandler,
                builder.fallbackEventHandler));
        registerEventHandlerCaller(new OptInEventHandlerCaller(builder.optInEventHandler,
                builder.fallbackEventHandler));

        logger.debug("{} initialized successfully.", MessengerReceiveClientImpl.class.getSimpleName());
    }

    private void registerEventHandlerCaller(EventHandlerCaller eventHandlerCaller) {
        this.eventHandlerCallers.add(eventHandlerCaller);
    }

    @Override
    public String verifyWebhook(String mode, String verifyToken, String challenge)
            throws MessengerVerificationException {

        PreConditions.notNullOrBlank(mode, "mode");
        PreConditions.notNullOrBlank(verifyToken, "verifyToken");
        PreConditions.notNullOrBlank(challenge, "challenge");

        if (!mode.equals(HUB_MODE_SUBSCRIBE)) {
            throw new MessengerVerificationException("Webhook verification failed. Mode '" + mode + "' is invalid.");
        }
        if (!verifyToken.equals(this.verifyToken)) {
            throw new MessengerVerificationException("Webhook verification failed. Verification token '" +
                    verifyToken + "' is invalid.");
        }
        return challenge;
    }

    @Override
    public void processCallbackPayload(String payload) {
        try {
            processCallbackPayload(payload, null);
        } catch (MessengerVerificationException e) {
            // cannot occur
            // in case signature verification is not disabled IllegalArgumentException is thrown by SignatureVerifier
            logger.error("unexpected behaviour", e);
        }
    }

    @Override
    public void processCallbackPayload(String payload, String signature) throws MessengerVerificationException {
        PreConditions.notNullOrBlank(payload, "payload");

        if (!this.disableSignatureVerification && !SignatureVerifier.isSignatureValid(payload, signature, this.appSecret)) {
            throw new MessengerVerificationException("Signature verification failed. " +
                    "Provided signature does not match calculated signature.");
        }

        final JsonObject payloadJsonObject = this.jsonParser.parse(payload).getAsJsonObject();

        final String objectType = JsonHelper.getPropertyAsString(payloadJsonObject, JsonHelper.Constants.PROP_OBJECT);
        if (objectType == null || !objectType.equalsIgnoreCase(OBJECT_TYPE_PAGE)) {
            throw new IllegalArgumentException("'object' property has to be 'page'. " +
                    "Make sure this is a page subscription");
        }

        final JsonArray entries = JsonHelper.getPropertyAsJsonArray(payloadJsonObject, JsonHelper.Constants.PROP_ENTRY);
        for (JsonElement entry : entries) {
            processEntry(entry.getAsJsonObject());
        }
    }

    private void processEntry(JsonObject entry) {
        final JsonArray messagingEvents = JsonHelper.getPropertyAsJsonArray(entry, JsonHelper.Constants.PROP_MESSAGING);
        for (JsonElement messagingEvent : messagingEvents) {
            processMessagingEvent(messagingEvent.getAsJsonObject());
        }
    }

    private void processMessagingEvent(JsonObject messagingEvent) {
        boolean eventHandlerCalled = false;
        for (EventHandlerCaller eventHandlerCaller : this.eventHandlerCallers) {
            eventHandlerCalled = eventHandlerCaller.callHandlerIfResponsibleForEvent(messagingEvent);
            if (eventHandlerCalled) {
                break;
            }
        }
        if (!eventHandlerCalled) {
            handleUnsupportedEventType(messagingEvent);
        }
    }

    private void handleUnsupportedEventType(JsonObject messagingEvent) {
        if (this.fallbackEventHandler != null) {
            logger.debug("Unsupported messaging event type. Calling {}.", FallbackEventHandler.class.getSimpleName());
            this.fallbackEventHandler.handle(FallbackEvent.fromJson(messagingEvent));
        } else {
            logger.warn("Unsupported messaging event type. Also the {} is not registered, hence the event will be discarded.",
                    FallbackEventHandler.class.getSimpleName());
        }
    }
}