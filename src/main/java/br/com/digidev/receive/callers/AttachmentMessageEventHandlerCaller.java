package br.com.digidev.receive.callers;

import br.com.digidev.internal.JsonHelper;
import br.com.digidev.receive.events.AttachmentMessageEvent;
import br.com.digidev.receive.handlers.EventHandler;
import br.com.digidev.receive.handlers.FallbackEventHandler;
import com.google.gson.JsonObject;

/**
 * <b>Internal</b> {@link EventHandlerCaller} responsible for the {@link AttachmentMessageEvent}.
 *
 * @author Max Grabenhorst
 * @since 0.6.0
 * @see EventHandlerCaller
 * @see EventHandler
 * @see FallbackEventHandler
 * @see AttachmentMessageEvent
 */
public final class AttachmentMessageEventHandlerCaller extends EventHandlerCaller<AttachmentMessageEvent> {

    public AttachmentMessageEventHandlerCaller(EventHandler<AttachmentMessageEvent> eventHandler,
                                               FallbackEventHandler fallbackEventHandler) {

        super(eventHandler, fallbackEventHandler);
    }

    @Override
    boolean isResponsible(JsonObject messagingEvent) {
        return JsonHelper.hasProperty(messagingEvent, JsonHelper.Constants.PROP_MESSAGE, JsonHelper.Constants.PROP_ATTACHMENTS) &&
                !JsonHelper.hasProperty(messagingEvent, JsonHelper.Constants.PROP_MESSAGE, JsonHelper.Constants.PROP_IS_ECHO);
    }

    @Override
    AttachmentMessageEvent createEventFromJson(JsonObject messagingEvent) {
        return AttachmentMessageEvent.fromJson(messagingEvent);
    }
}
