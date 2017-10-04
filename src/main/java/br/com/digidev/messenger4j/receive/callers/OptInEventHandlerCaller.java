package br.com.digidev.messenger4j.receive.callers;

import br.com.digidev.messenger4j.internal.JsonHelper;
import br.com.digidev.messenger4j.receive.events.OptInEvent;
import br.com.digidev.messenger4j.receive.handlers.EventHandler;
import br.com.digidev.messenger4j.receive.handlers.FallbackEventHandler;
import com.google.gson.JsonObject;

/**
 * <b>Internal</b> {@link EventHandlerCaller} responsible for the {@link OptInEvent}.
 *
 * @author Messenger4J - http://github.com/messenger4j
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
