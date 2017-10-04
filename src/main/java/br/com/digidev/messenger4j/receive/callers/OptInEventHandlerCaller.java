package br.com.digidev.messenger4j.receive.callers;

import static br.com.digidev.messenger4j.internal.JsonHelper.Constants.PROP_OPTIN;
import static br.com.digidev.messenger4j.internal.JsonHelper.hasProperty;

import br.com.digidev.messenger4j.receive.handlers.EventHandler;
import br.com.digidev.messenger4j.receive.handlers.FallbackEventHandler;
import br.com.digidev.messenger4j.receive.events.OptInEvent;
import com.google.gson.JsonObject;

/**
 * <b>Internal</b> {@link EventHandlerCaller} responsible for the {@link OptInEvent}.
 *
 * @author Max Grabenhorst
 * @since 0.6.0
 * @see EventHandlerCaller
 * @see EventHandler
 * @see FallbackEventHandler
 * @see OptInEvent
 */
public final class OptInEventHandlerCaller extends EventHandlerCaller<OptInEvent> {

    public OptInEventHandlerCaller(EventHandler<OptInEvent> eventHandler,
                                   FallbackEventHandler fallbackEventHandler) {

        super(eventHandler, fallbackEventHandler);
    }

    @Override
    boolean isResponsible(JsonObject messagingEvent) {
        return hasProperty(messagingEvent, PROP_OPTIN);
    }

    @Override
    OptInEvent createEventFromJson(JsonObject messagingEvent) {
        return OptInEvent.fromJson(messagingEvent);
    }
}
