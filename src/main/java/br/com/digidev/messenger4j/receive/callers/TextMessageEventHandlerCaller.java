package br.com.digidev.messenger4j.receive.callers;

import br.com.digidev.messenger4j.internal.JsonHelper;
import br.com.digidev.messenger4j.receive.events.TextMessageEvent;
import br.com.digidev.messenger4j.receive.handlers.EventHandler;
import br.com.digidev.messenger4j.receive.handlers.FallbackEventHandler;
import com.google.gson.JsonObject;

/**
 * <b>Internal</b> {@link EventHandlerCaller} responsible for the {@link TextMessageEvent}.
 *
 * @author Max Grabenhorst
 * @see EventHandlerCaller
 * @see EventHandler
 * @see FallbackEventHandler
 * @see TextMessageEvent
 * @since 0.6.0
 */
public final class TextMessageEventHandlerCaller extends EventHandlerCaller<TextMessageEvent> {

    public TextMessageEventHandlerCaller(EventHandler<TextMessageEvent> eventHandler,
                                         FallbackEventHandler fallbackEventHandler) {

        super(eventHandler, fallbackEventHandler);
    }

    @Override
    boolean isResponsible(JsonObject messagingEvent) {
        return JsonHelper.hasProperty(messagingEvent, JsonHelper.Constants.PROP_MESSAGE, JsonHelper.Constants.PROP_TEXT) &&
                !JsonHelper.hasProperty(messagingEvent, JsonHelper.Constants.PROP_MESSAGE, JsonHelper.Constants.PROP_QUICK_REPLY) &&
                !JsonHelper.hasProperty(messagingEvent, JsonHelper.Constants.PROP_MESSAGE, JsonHelper.Constants.PROP_IS_ECHO);
    }

    @Override
    TextMessageEvent createEventFromJson(JsonObject messagingEvent) {
        return TextMessageEvent.fromJson(messagingEvent);
    }
}
