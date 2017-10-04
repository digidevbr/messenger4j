package br.com.digidev.messenger4j.receive.callers;

import br.com.digidev.messenger4j.internal.JsonHelper;
import br.com.digidev.messenger4j.receive.events.EchoMessageEvent;
import br.com.digidev.messenger4j.receive.handlers.EventHandler;
import br.com.digidev.messenger4j.receive.handlers.FallbackEventHandler;
import com.google.gson.JsonObject;

/**
 * <b>Internal</b> {@link EventHandlerCaller} responsible for the {@link EchoMessageEvent}.
 *
 * @author Messenger4J - http://github.com/messenger4j
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
