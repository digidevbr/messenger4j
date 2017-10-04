package br.com.digidev.receive.events;

import br.com.digidev.internal.JsonHelper;
import com.google.gson.JsonObject;
import java.util.Date;

/**
 * This event will occur when a {@code text message} has been sent to your page.
 *
 * <p>
 * For further information refer to:<br>
 * <a href="https://developers.facebook.com/docs/messenger-platform/webhook-reference/message">
 * https://developers.facebook.com/docs/messenger-platform/webhook-reference/message
 * </a>
 * </p>
 *
 * @author Max Grabenhorst
 * @since 0.6.0
 * @see Event
 */
public final class TextMessageEvent extends CommonTextMessageEvent {

    /**
     * <b>Internal</b> method to create an instance of {@link TextMessageEvent} from the given
     * event as JSON structure.
     *
     * @param jsonObject the event as JSON structure
     * @return the created {@link TextMessageEvent}
     */
    public static TextMessageEvent fromJson(JsonObject jsonObject) {
        final String senderId = JsonHelper.getPropertyAsString(jsonObject, JsonHelper.Constants.PROP_SENDER, JsonHelper.Constants.PROP_ID);
        final String recipientId = JsonHelper.getPropertyAsString(jsonObject, JsonHelper.Constants.PROP_RECIPIENT, JsonHelper.Constants.PROP_ID);
        final Date timestamp = JsonHelper.getPropertyAsDate(jsonObject, JsonHelper.Constants.PROP_TIMESTAMP);
        final String mid = JsonHelper.getPropertyAsString(jsonObject, JsonHelper.Constants.PROP_MESSAGE, JsonHelper.Constants.PROP_MID);
        final String text = JsonHelper.getPropertyAsString(jsonObject, JsonHelper.Constants.PROP_MESSAGE, JsonHelper.Constants.PROP_TEXT);

        return new TextMessageEvent(senderId, recipientId, timestamp, mid, text);
    }

    public TextMessageEvent(String senderId, String recipientId, Date timestamp, String mid, String text) {
        super(senderId, recipientId, timestamp, mid, text);
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
        return "TextMessageEvent{} super=" + super.toString();
    }
}