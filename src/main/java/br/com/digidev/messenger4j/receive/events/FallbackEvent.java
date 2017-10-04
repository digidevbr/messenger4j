package br.com.digidev.messenger4j.receive.events;

import br.com.digidev.messenger4j.internal.JsonHelper;
import br.com.digidev.messenger4j.receive.handlers.EventHandler;
import com.google.gson.JsonObject;

/**
 * This event will occur when either the actual event is not supported by this library or the specific
 * {@link EventHandler} for the actual event (when supported) is not registered.
 *
 * @author Messenger4J - http://github.com/messenger4j
 * @see Event
 */
public final class FallbackEvent extends Event {

    /**
     * <b>Internal</b> method to create an instance of {@link FallbackEvent} from the given {@link Event}.
     *
     * @param event an instance of {@link Event}
     * @return the created {@link FallbackEvent}
     */
    public static FallbackEvent fromEvent(Event event) {
        final String senderId = event.getSender().getId();
        final String recipientId = event.getRecipient().getId();
        return new FallbackEvent(senderId, recipientId);
    }

    /**
     * <b>Internal</b> method to create an instance of {@link FallbackEvent} from the given
     * event as JSON structure.
     *
     * @param jsonObject the event as JSON structure
     * @return the created {@link FallbackEvent}
     */
    public static FallbackEvent fromJson(JsonObject jsonObject) {
        final String senderId = JsonHelper.getPropertyAsString(jsonObject, JsonHelper.Constants.PROP_SENDER, JsonHelper.Constants.PROP_ID);
        final String recipientId = JsonHelper.getPropertyAsString(jsonObject, JsonHelper.Constants.PROP_RECIPIENT, JsonHelper.Constants.PROP_ID);
        return new FallbackEvent(senderId, recipientId);
    }

    public FallbackEvent(String senderId, String recipientId) {
        super(senderId, recipientId);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "FallbackEvent{} super=" + super.toString();
    }
}