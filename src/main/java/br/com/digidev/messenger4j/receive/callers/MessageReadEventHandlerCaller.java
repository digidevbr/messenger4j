package br.com.digidev.messenger4j.receive.callers;

import static br.com.digidev.messenger4j.internal.JsonHelper.Constants.PROP_READ;
import static br.com.digidev.messenger4j.internal.JsonHelper.hasProperty;

import br.com.digidev.messenger4j.receive.events.MessageReadEvent;
import br.com.digidev.messenger4j.receive.handlers.EventHandler;
import br.com.digidev.messenger4j.receive.handlers.FallbackEventHandler;
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
        return hasProperty(messagingEvent, PROP_READ);
    }

    @Override
    MessageReadEvent createEventFromJson(JsonObject messagingEvent) {
        return MessageReadEvent.fromJson(messagingEvent);
    }
}
