package br.com.digidev.messenger4j.receive.events;

import br.com.digidev.messenger4j.internal.JsonHelper;
import com.google.gson.JsonObject;
import java.util.Date;
import java.util.Objects;

/**
 * This event will occur when a {@code Quick Reply} button has been tapped.
 *
 * <p>
 * For further information refer to:<br>
 * <a href="https://developers.facebook.com/docs/messenger-platform/webhook-reference/message">
 * https://developers.facebook.com/docs/messenger-platform/webhook-reference/message
 * </a>
 * </p>
 *
 * @author Messenger4J - http://github.com/messenger4j
 * @see Event
 */
public final class QuickReplyMessageEvent extends CommonTextMessageEvent {

    private final QuickReply quickReply;

    /**
     * <b>Internal</b> method to create an instance of {@link QuickReplyMessageEvent} from the given
     * event as JSON structure.
     *
     * @param jsonObject the event as JSON structure
     * @return the created {@link QuickReplyMessageEvent}
     */
    public static QuickReplyMessageEvent fromJson(JsonObject jsonObject) {
        final String senderId = JsonHelper.getPropertyAsString(jsonObject, JsonHelper.Constants.PROP_SENDER, JsonHelper.Constants.PROP_ID);
        final String recipientId = JsonHelper.getPropertyAsString(jsonObject, JsonHelper.Constants.PROP_RECIPIENT, JsonHelper.Constants.PROP_ID);
        final Date timestamp = JsonHelper.getPropertyAsDate(jsonObject, JsonHelper.Constants.PROP_TIMESTAMP);
        final String mid = JsonHelper.getPropertyAsString(jsonObject, JsonHelper.Constants.PROP_MESSAGE, JsonHelper.Constants.PROP_MID);
        final String text = JsonHelper.getPropertyAsString(jsonObject, JsonHelper.Constants.PROP_MESSAGE, JsonHelper.Constants.PROP_TEXT);
        final JsonObject quickReplyJsonObject = JsonHelper.getPropertyAsJsonObject(jsonObject, JsonHelper.Constants.PROP_MESSAGE, JsonHelper.Constants.PROP_QUICK_REPLY);

        final QuickReply quickReply = QuickReply.fromJson(quickReplyJsonObject);
        return new QuickReplyMessageEvent(senderId, recipientId, timestamp, mid, text, quickReply);
    }

    public QuickReplyMessageEvent(String senderId, String recipientId, Date timestamp, String mid, String text,
                                   QuickReply quickReply) {

        super(senderId, recipientId, timestamp, mid, text);
        this.quickReply = quickReply;
    }

    public QuickReply getQuickReply() {
        return quickReply;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        QuickReplyMessageEvent that = (QuickReplyMessageEvent) o;
        return Objects.equals(quickReply, that.quickReply);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), quickReply);
    }

    @Override
    public String toString() {
        return "QuickReplyMessageEvent{" +
                "quickReply=" + quickReply +
                "} super=" + super.toString();
    }

    /**
     * Custom data that is provided when the user taps on a {@code Quick Reply} button.
     *
     * @author Messenger4J - http://github.com/messenger4j
     */
    public static final class QuickReply {

        private final String payload;

        private static QuickReply fromJson(JsonObject jsonObject) {
            final String payload = JsonHelper.getPropertyAsString(jsonObject, JsonHelper.Constants.PROP_PAYLOAD);
            return new QuickReply(payload);
        }

        public QuickReply(String payload) {
            this.payload = payload;
        }

        public String getPayload() {
            return payload;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            QuickReply that = (QuickReply) o;
            return Objects.equals(payload, that.payload);
        }

        @Override
        public int hashCode() {
            return Objects.hash(payload);
        }

        @Override
        public String toString() {
            return "QuickReply{" +
                    "payload='" + payload + '\'' +
                    '}';
        }
    }
}