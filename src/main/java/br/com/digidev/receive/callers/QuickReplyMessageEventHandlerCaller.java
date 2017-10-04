package br.com.digidev.receive.callers;

import br.com.digidev.internal.JsonHelper;
import br.com.digidev.receive.handlers.FallbackEventHandler;
import br.com.digidev.receive.events.QuickReplyMessageEvent;
import br.com.digidev.receive.handlers.EventHandler;
import com.google.gson.JsonObject;

/**
 * <b>Internal</b> {@link EventHandlerCaller} responsible for the {@link QuickReplyMessageEvent}.
 *
 * @author Max Grabenhorst
 * @since 0.6.0
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
