package br.com.digidev.messenger4j.receive.callers;

import br.com.digidev.messenger4j.internal.JsonHelper;
import br.com.digidev.messenger4j.receive.handlers.EventHandler;
import br.com.digidev.messenger4j.receive.handlers.FallbackEventHandler;
import br.com.digidev.messenger4j.receive.events.PostbackEvent;
import com.google.gson.JsonObject;

/**
 * <b>Internal</b> {@link EventHandlerCaller} responsible for the {@link PostbackEvent}.
 *
 * @author Messenger4J - http://github.com/messenger4j
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
