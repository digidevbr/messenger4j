package br.com.digidev.receive.callers;

import br.com.digidev.internal.JsonHelper;
import br.com.digidev.receive.handlers.EventHandler;
import br.com.digidev.receive.handlers.FallbackEventHandler;
import br.com.digidev.receive.events.OptInEvent;
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
        return JsonHelper.hasProperty(messagingEvent, JsonHelper.Constants.PROP_OPTIN);
    }

    @Override
    OptInEvent createEventFromJson(JsonObject messagingEvent) {
        return OptInEvent.fromJson(messagingEvent);
    }
}
