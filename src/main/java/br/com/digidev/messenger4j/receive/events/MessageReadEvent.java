package br.com.digidev.messenger4j.receive.events;

import br.com.digidev.messenger4j.internal.JsonHelper;
import com.google.gson.JsonObject;
import java.util.Date;
import java.util.Objects;

/**
 * This event will occur when a message a page has sent has been read by the user.
 *
 * <p>
 * For further information refer to:<br>
 * <a href="https://developers.facebook.com/docs/messenger-platform/webhook-reference/message-read">
 * https://developers.facebook.com/docs/messenger-platform/webhook-reference/message-read
 * </a>
 * </p>
 *
 * @author Max Grabenhorst
 * @since 0.6.0
 * @see Event
 */
public final class MessageReadEvent extends TimestampedEvent {

    private final Date watermark;

    /**
     * <b>Internal</b> method to create an instance of {@link MessageReadEvent} from the given
     * event as JSON structure.
     *
     * @param jsonObject the event as JSON structure
     * @return the created {@link MessageReadEvent}
     */
    public static MessageReadEvent fromJson(JsonObject jsonObject) {
        final String senderId = JsonHelper.getPropertyAsString(jsonObject, JsonHelper.Constants.PROP_SENDER, JsonHelper.Constants.PROP_ID);
        final String recipientId = JsonHelper.getPropertyAsString(jsonObject, JsonHelper.Constants.PROP_RECIPIENT, JsonHelper.Constants.PROP_ID);
        final Date timestamp = JsonHelper.getPropertyAsDate(jsonObject, JsonHelper.Constants.PROP_TIMESTAMP);
        final Date watermark = JsonHelper.getPropertyAsDate(jsonObject, JsonHelper.Constants.PROP_READ, JsonHelper.Constants.PROP_WATERMARK);

        return new MessageReadEvent(senderId, recipientId, timestamp, watermark);
    }

    public MessageReadEvent(String senderId, String recipientId, Date timestamp, Date watermark) {
        super(senderId, recipientId, timestamp);
        this.watermark = watermark;
    }

    public Date getWatermark() {
        return watermark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MessageReadEvent that = (MessageReadEvent) o;
        return Objects.equals(watermark, that.watermark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), watermark);
    }

    @Override
    public String toString() {
        return "MessageReadEvent{" +
                "watermark=" + watermark +
                "} super=" + super.toString();
    }
}