package br.com.digidev.receive.callers;

import br.com.digidev.internal.JsonHelper;
import br.com.digidev.receive.events.PostbackEvent;
import br.com.digidev.receive.handlers.EventHandler;
import br.com.digidev.receive.handlers.FallbackEventHandler;
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
        return JsonHelper.hasProperty(messagingEvent, JsonHelper.Constants.PROP_POSTBACK);
    }

    @Override
    PostbackEvent createEventFromJson(JsonObject messagingEvent) {
        return PostbackEvent.fromJson(messagingEvent);
    }
}
