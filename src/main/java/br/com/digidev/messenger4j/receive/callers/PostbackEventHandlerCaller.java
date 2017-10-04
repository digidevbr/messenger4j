package br.com.digidev.messenger4j.receive.callers;

import static br.com.digidev.messenger4j.internal.JsonHelper.Constants.PROP_POSTBACK;
import static br.com.digidev.messenger4j.internal.JsonHelper.hasProperty;

import br.com.digidev.messenger4j.receive.events.PostbackEvent;
import br.com.digidev.messenger4j.receive.handlers.EventHandler;
import br.com.digidev.messenger4j.receive.handlers.FallbackEventHandler;
import com.google.gson.JsonObject;

/**
 * <b>Internal</b> {@link EventHandlerCaller} responsible for the {@link PostbackEvent}.
 *
 * @author Max Grabenhorst
 * @since 0.6.0
 * @see EventHandlerCaller
 * @see EventHandler
 * @see FallbackEventHandler
 * @see PostbackEvent
 */
public final class PostbackEventHandlerCaller extends EventHandlerCaller<PostbackEvent> {

    public PostbackEventHandlerCaller(EventHandler<PostbackEvent> eventHandler,
                                      FallbackEventHandler fallbackEventHandler) {

        super(eventHandler, fallbackEventHandler);
    }

    @Override
    boolean isResponsible(JsonObject messagingEvent) {
        return hasProperty(messagingEvent, PROP_POSTBACK);
    }

    @Override
    PostbackEvent createEventFromJson(JsonObject messagingEvent) {
        return PostbackEvent.fromJson(messagingEvent);
    }
}
