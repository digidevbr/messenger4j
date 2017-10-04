package br.com.digidev.messenger4j.receive.callers;

import static br.com.digidev.messenger4j.internal.JsonHelper.Constants.PROP_IS_ECHO;
import static br.com.digidev.messenger4j.internal.JsonHelper.Constants.PROP_MESSAGE;
import static br.com.digidev.messenger4j.internal.JsonHelper.hasProperty;

import br.com.digidev.messenger4j.receive.handlers.EventHandler;
import br.com.digidev.messenger4j.receive.handlers.FallbackEventHandler;
import br.com.digidev.messenger4j.receive.events.EchoMessageEvent;
import com.google.gson.JsonObject;

/**
 * <b>Internal</b> {@link EventHandlerCaller} responsible for the {@link EchoMessageEvent}.
 *
 * @author Max Grabenhorst
 * @since 0.6.0
 * @see EventHandlerCaller
 * @see EventHandler
 * @see FallbackEventHandler
 * @see EchoMessageEvent
 */
public final class EchoMessageEventHandlerCaller extends EventHandlerCaller<EchoMessageEvent> {

    public EchoMessageEventHandlerCaller(EventHandler<EchoMessageEvent> eventHandler,
                                         FallbackEventHandler fallbackEventHandler) {

        super(eventHandler, fallbackEventHandler);
    }

    @Override
    boolean isResponsible(JsonObject messagingEvent) {
        return hasProperty(messagingEvent, PROP_MESSAGE, PROP_IS_ECHO);
    }

    @Override
    EchoMessageEvent createEventFromJson(JsonObject messagingEvent) {
        return EchoMessageEvent.fromJson(messagingEvent);
    }
}
