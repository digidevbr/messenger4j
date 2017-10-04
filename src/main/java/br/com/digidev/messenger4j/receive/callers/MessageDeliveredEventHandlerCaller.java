package br.com.digidev.messenger4j.receive.callers;

import br.com.digidev.messenger4j.internal.JsonHelper;
import br.com.digidev.messenger4j.receive.handlers.EventHandler;
import br.com.digidev.messenger4j.receive.handlers.FallbackEventHandler;
import br.com.digidev.messenger4j.receive.events.MessageDeliveredEvent;
import com.google.gson.JsonObject;

/**
 * <b>Internal</b> {@link EventHandlerCaller} responsible for the {@link MessageDeliveredEvent}.
 *
 * @author Max Grabenhorst
 * @since 0.6.0
 * @see EventHandlerCaller
 * @see EventHandler
 * @see FallbackEventHandler
 * @see MessageDeliveredEvent
 */
public final class MessageDeliveredEventHandlerCaller extends EventHandlerCaller<MessageDeliveredEvent> {

    public MessageDeliveredEventHandlerCaller(EventHandler<MessageDeliveredEvent> eventHandler,
                                              FallbackEventHandler fallbackEventHandler) {

        super(eventHandler, fallbackEventHandler);
    }

    @Override
    boolean isResponsible(JsonObject messagingEvent) {
        return JsonHelper.hasProperty(messagingEvent, JsonHelper.Constants.PROP_DELIVERY);
    }

    @Override
    MessageDeliveredEvent createEventFromJson(JsonObject messagingEvent) {
        return MessageDeliveredEvent.fromJson(messagingEvent);
    }
}
