package br.com.digidev.messenger4j.receive.callers;

import br.com.digidev.messenger4j.internal.JsonHelper;
import br.com.digidev.messenger4j.receive.events.AccountLinkingEvent;
import br.com.digidev.messenger4j.receive.handlers.EventHandler;
import br.com.digidev.messenger4j.receive.handlers.FallbackEventHandler;
import com.google.gson.JsonObject;

/**
 * <b>Internal</b> {@link EventHandlerCaller} responsible for the {@link AccountLinkingEvent}.
 *
 * @author Max Grabenhorst
 * @since 0.6.0
 * @see EventHandlerCaller
 * @see EventHandler
 * @see FallbackEventHandler
 * @see AccountLinkingEvent
 */
public final class AccountLinkingEventHandlerCaller extends EventHandlerCaller<AccountLinkingEvent> {

    public AccountLinkingEventHandlerCaller(EventHandler<AccountLinkingEvent> eventHandler,
                                            FallbackEventHandler fallbackEventHandler) {

        super(eventHandler, fallbackEventHandler);
    }

    @Override
    boolean isResponsible(JsonObject messagingEvent) {
        return JsonHelper.hasProperty(messagingEvent, JsonHelper.Constants.PROP_ACCOUNT_LINKING);
    }

    @Override
    AccountLinkingEvent createEventFromJson(JsonObject messagingEvent) {
        return AccountLinkingEvent.fromJson(messagingEvent);
    }
}
