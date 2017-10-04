package br.com.digidev.messenger4j.receive.events;

import br.com.digidev.messenger4j.internal.JsonHelper;
import com.google.gson.JsonObject;
import java.util.Date;
import java.util.Objects;

/**
 * This event will occur when a message has been sent by your page.
 *
 * <p>
 * For further information refer to:<br>
 * <a href="https://developers.facebook.com/docs/messenger-platform/webhook-reference/message-echo">
 * https://developers.facebook.com/docs/messenger-platform/webhook-reference/message-echo
 * </a>
 * </p>
 *
 * @author Messenger4J - http://github.com/messenger4j
 * @see Event
 */
public final class EchoMessageEvent extends MessageEvent {

    private final String appId;
    private final String metadata;

    /**
     * <b>Internal</b> method to create an instance of {@link EchoMessageEvent} from the given
     * event as JSON structure.
     *
     * @param jsonObject the event as JSON structure
     * @return the created {@link EchoMessageEvent}
     */
    public static EchoMessageEvent fromJson(JsonObject jsonObject) {
        final String senderId = JsonHelper.getPropertyAsString(jsonObject, JsonHelper.Constants.PROP_SENDER, JsonHelper.Constants.PROP_ID);
        final String recipientId = JsonHelper.getPropertyAsString(jsonObject, JsonHelper.Constants.PROP_RECIPIENT, JsonHelper.Constants.PROP_ID);
        final Date timestamp = JsonHelper.getPropertyAsDate(jsonObject, JsonHelper.Constants.PROP_TIMESTAMP);
        final String mid = JsonHelper.getPropertyAsString(jsonObject, JsonHelper.Constants.PROP_MESSAGE, JsonHelper.Constants.PROP_MID);
        final String appId = JsonHelper.getPropertyAsString(jsonObject, JsonHelper.Constants.PROP_MESSAGE, JsonHelper.Constants.PROP_APP_ID);
        final String metadata = JsonHelper.getPropertyAsString(jsonObject, JsonHelper.Constants.PROP_MESSAGE, JsonHelper.Constants.PROP_METADATA);

        return new EchoMessageEvent(senderId, recipientId, timestamp, mid, appId, metadata);
    }

    public EchoMessageEvent(String senderId, String recipientId, Date timestamp, String mid, String appId,
                             String metadata) {

        super(senderId, recipientId, timestamp, mid);
        this.appId = appId;
        this.metadata = metadata;
    }

    public String getAppId() {
        return appId;
    }

    public String getMetadata() {
        return metadata;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EchoMessageEvent that = (EchoMessageEvent) o;
        return Objects.equals(appId, that.appId) &&
                Objects.equals(metadata, that.metadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), appId, metadata);
    }

    @Override
    public String toString() {
        return "EchoMessageEvent{" +
                "appId='" + appId + '\'' +
                ", metadata='" + metadata + '\'' +
                "} super=" + super.toString();
    }
}