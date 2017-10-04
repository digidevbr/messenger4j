package br.com.digidev.messenger4j.receive.callers;

import br.com.digidev.messenger4j.internal.JsonHelper;
import br.com.digidev.messenger4j.receive.events.AttachmentMessageEvent;
import br.com.digidev.messenger4j.receive.handlers.EventHandler;
import br.com.digidev.messenger4j.receive.handlers.FallbackEventHandler;
import com.google.gson.JsonObject;

/**
 * <b>Internal</b> {@link EventHandlerCaller} responsible for the {@link AttachmentMessageEvent}.
 *
 * @author Messenger4J - http://github.com/messenger4j
 * @see EventHandlerCaller
 * @see EventHandler
 * @see FallbackEventHandler
 * @see AttachmentMessageEvent
 */
public final class AttachmentMessageEventHandlerCaller extends EventHandlerCaller<AttachmentMessageEvent> {

    public AttachmentMessageEventHandlerCaller(EventHandler<AttachmentMessageEvent> eventHandler,
                                               FallbackEventHandler fallbackEventHandler) {

        super(eventHandler, fallbackEventHandler);
    }

    @Override
    boolean isResponsible(JsonObject messagingEvent) {
        return JsonHelper.hasProperty(messagingEvent, JsonHelper.Constants.PROP_MESSAGE, JsonHelper.Constants.PROP_ATTACHMENTS) &&
                !JsonHelper.hasProperty(messagingEvent, JsonHelper.Constants.PROP_MESSAGE, JsonHelper.Constants.PROP_IS_ECHO);
    }

    @Override
    AttachmentMessageEvent createEventFromJson(JsonObject messagingEvent) {
        return AttachmentMessageEvent.fromJson(messagingEvent);
    }
}
