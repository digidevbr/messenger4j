package br.com.digidev.messenger4j.send;

import br.com.digidev.messenger4j.internal.JsonHelper;
import com.google.gson.JsonObject;

import java.util.Objects;

/**
 * @author Messenger4J - http://github.com/messenger4j
 */
public final class MessengerResponse {

    private final String recipientId;
    private final String messageId;
    private final String attachmentId;

    public static MessengerResponse fromJson(JsonObject jsonObject) {
        final String recipientId = JsonHelper.getPropertyAsString(jsonObject, JsonHelper.Constants.PROP_RECIPIENT_ID);
        final String messageId = JsonHelper.getPropertyAsString(jsonObject, JsonHelper.Constants.PROP_MESSAGE_ID);
        final String attachmentId = JsonHelper.getPropertyAsString(jsonObject, JsonHelper.Constants.PROP_ATTACHMENT_ID);
        return new MessengerResponse(recipientId, messageId, attachmentId);
    }

    private MessengerResponse(String recipientId, String messageId, String attachmentId) {
        this.recipientId = recipientId;
        this.messageId = messageId;
        this.attachmentId = attachmentId;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public String getMessageId() {
        return messageId;
    }

    public String getAttachmentId() {
        return this.attachmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessengerResponse that = (MessengerResponse) o;
        return Objects.equals(recipientId, that.recipientId) &&
                Objects.equals(messageId, that.messageId) &&
                Objects.equals(attachmentId, that.attachmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipientId, messageId, attachmentId);
    }

    @Override
    public String toString() {
        return "MessengerResponse{" +
                "recipientId='" + recipientId + '\'' +
                ", messageId='" + messageId + '\'' +
                ", attachmentId='" + attachmentId + '\'' +
                '}';
    }
}