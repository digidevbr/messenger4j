package br.com.digidev.receive.callers;

import br.com.digidev.internal.JsonHelper;
import br.com.digidev.receive.handlers.EventHandler;
import br.com.digidev.receive.handlers.FallbackEventHandler;
import br.com.digidev.receive.events.EchoMessageEvent;
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
        return JsonHelper.hasProperty(messagingEvent, JsonHelper.Constants.PROP_MESSAGE, JsonHelper.Constants.PROP_IS_ECHO);
    }

    @Override
    EchoMessageEvent createEventFromJson(JsonObject messagingEvent) {
        return EchoMessageEvent.fromJson(messagingEvent);
    }
}