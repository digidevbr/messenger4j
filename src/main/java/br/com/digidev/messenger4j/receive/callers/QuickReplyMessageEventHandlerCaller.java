package br.com.digidev.messenger4j.receive.callers;

import br.com.digidev.messenger4j.internal.JsonHelper;
import br.com.digidev.messenger4j.receive.handlers.EventHandler;
import br.com.digidev.messenger4j.receive.handlers.FallbackEventHandler;
import br.com.digidev.messenger4j.receive.events.QuickReplyMessageEvent;
import com.google.gson.JsonObject;

/**
 * <b>Internal</b> {@link EventHandlerCaller} responsible for the {@link QuickReplyMessageEvent}.
 *
 * @author Messenger4J - http://github.com/messenger4j
 * @see EventHandlerCaller
 * @see EventHandler
 * @see FallbackEventHandler
 * @see QuickReplyMessageEvent
 */
public final class QuickReplyMessageEventHandlerCaller extends EventHandlerCaller<QuickReplyMessageEvent> {

    public QuickReplyMessageEventHandlerCaller(EventHandler<QuickReplyMessageEvent> eventHandler,
                                               FallbackEventHandler fallbackEventHandler) {

        super(eventHandler, fallbackEventHandler);
    }

    @Override
    boolean isResponsible(JsonObject messagingEvent) {
        return JsonHelper.hasProperty(messagingEvent, JsonHelper.Constants.PROP_MESSAGE, JsonHelper.Constants.PROP_TEXT)
                && JsonHelper.hasProperty(messagingEvent, JsonHelper.Constants.PROP_MESSAGE, JsonHelper.Constants.PROP_QUICK_REPLY);
    }

    @Override
    QuickReplyMessageEvent createEventFromJson(JsonObject messagingEvent) {
        return QuickReplyMessageEvent.fromJson(messagingEvent);
    }
}
