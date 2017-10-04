package br.com.digidev.messenger4j.receive.events;

import br.com.digidev.messenger4j.internal.JsonHelper;
import com.google.gson.JsonObject;
import java.util.Date;
import java.util.Objects;

/**
 * This event will occur when the {@code Send-to-Messenger} plugin has been tapped.
 *
 * <p>
 * For further information refer to:<br>
 * <a href="https://developers.facebook.com/docs/messenger-platform/webhook-reference/optins">
 * https://developers.facebook.com/docs/messenger-platform/webhook-reference/optins
 * </a>
 * </p>
 *
 * @author Max Grabenhorst
 * @since 0.6.0
 * @see Event
 */
public final class OptInEvent extends TimestampedEvent {

    private final String ref;

    /**
     * <b>Internal</b> method to create an instance of {@link OptInEvent} from the given
     * event as JSON structure.
     *
     * @param jsonObject the event as JSON structure
     * @return the created {@link OptInEvent}
     */
    public static OptInEvent fromJson(JsonObject jsonObject) {
        final String senderId = JsonHelper.getPropertyAsString(jsonObject, JsonHelper.Constants.PROP_SENDER, JsonHelper.Constants.PROP_ID);
        final String recipientId = JsonHelper.getPropertyAsString(jsonObject, JsonHelper.Constants.PROP_RECIPIENT, JsonHelper.Constants.PROP_ID);
        final Date timestamp = JsonHelper.getPropertyAsDate(jsonObject, JsonHelper.Constants.PROP_TIMESTAMP);
        final String ref = JsonHelper.getPropertyAsString(jsonObject, JsonHelper.Constants.PROP_OPTIN, JsonHelper.Constants.PROP_REF);

        return new OptInEvent(senderId, recipientId, timestamp, ref);
    }

    public OptInEvent(String senderId, String recipientId, Date timestamp, String ref) {
        super(senderId, recipientId, timestamp);
        this.ref = ref;
    }

    public String getRef() {
        return ref;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OptInEvent that = (OptInEvent) o;
        return Objects.equals(ref, that.ref);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ref);
    }

    @Override
    public String toString() {
        return "OptInEvent{" +
                "ref='" + ref + '\'' +
                "} super=" + super.toString();
    }
}