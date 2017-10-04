package br.com.digidev.receive.callers;

import br.com.digidev.internal.JsonHelper;
import br.com.digidev.receive.events.MessageReadEvent;
import br.com.digidev.receive.handlers.EventHandler;
import br.com.digidev.receive.handlers.FallbackEventHandler;
import com.google.gson.JsonObject;

/**
 * <b>Internal</b> {@link EventHandlerCaller} responsible for the {@link MessageReadEvent}.
 *
 * @author Max Grabenhorst
 * @since 0.6.0
 * @see EventHandlerCaller
 * @see EventHandler
 * @see FallbackEventHandler
 * @see MessageReadEvent
 */
public final class MessageReadEventHandlerCaller extends EventHandlerCaller<MessageReadEvent> {

    public MessageReadEventHandlerCaller(EventHandler<MessageReadEvent> eventHandler,
                                         FallbackEventHandler fallbackEventHandler) {

        super(eventHandler, fallbackEventHandler);
    }

    @Override
    boolean isResponsible(JsonObject messagingEvent) {
        return JsonHelper.hasProperty(messagingEvent, JsonHelper.Constants.PROP_READ);
    }

    @Override
    MessageReadEvent createEventFromJson(JsonObject messagingEvent) {
        return MessageReadEvent.fromJson(messagingEvent);
    }
}
