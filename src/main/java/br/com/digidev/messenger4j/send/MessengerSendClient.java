package br.com.digidev.messenger4j.send;

import br.com.digidev.messenger4j.exceptions.MessengerApiException;
import br.com.digidev.messenger4j.exceptions.MessengerIOException;
import br.com.digidev.messenger4j.send.templates.Template;

import java.util.List;

/**
 * @author Messenger4J - http://github.com/messenger4j
 */
public interface MessengerSendClient {

    /*
        SENDER_ACTION
     */
    MessengerResponse sendSenderAction(String recipientId, SenderAction senderAction)
            throws MessengerApiException, MessengerIOException;

    MessengerResponse sendSenderAction(Recipient recipient, NotificationType notificationType, SenderAction senderAction)
            throws MessengerApiException, MessengerIOException;

    /*
        TEXT_MESSAGE
     */
    MessengerResponse sendTextMessage(String recipientId, String text)
            throws MessengerApiException, MessengerIOException;

    MessengerResponse sendTextMessage(String recipientId, String text, List<QuickReply> quickReplies)
            throws MessengerApiException, MessengerIOException;

    MessengerResponse sendTextMessage(Recipient recipient, NotificationType notificationType, String text)
            throws MessengerApiException, MessengerIOException;

    MessengerResponse sendTextMessage(Recipient recipient, NotificationType notificationType, String text,
                                      List<QuickReply> quickReplies)
            throws MessengerApiException, MessengerIOException;

    MessengerResponse sendTextMessage(Recipient recipient, NotificationType notificationType, String text,
                                      String metadata)
            throws MessengerApiException, MessengerIOException;

    MessengerResponse sendTextMessage(Recipient recipient, NotificationType notificationType, String text,
                                      List<QuickReply> quickReplies, String metadata)
            throws MessengerApiException, MessengerIOException;

    /*
        IMAGE_ATTACHMENT
     */
    MessengerResponse sendImageAttachment(String recipientId, String imageUrl)
            throws MessengerApiException, MessengerIOException;

    MessengerResponse sendImageAttachment(String recipientId, String imageUrl, List<QuickReply> quickReplies)
            throws MessengerApiException, MessengerIOException;

    /*
        AUDIO_ATTACHMENT
     */
    MessengerResponse sendAudioAttachment(String recipientId, String audioUrl)
            throws MessengerApiException, MessengerIOException;

    /*
        VIDEO_ATTACHMENT
     */
    MessengerResponse sendVideoAttachment(String recipientId, String videoUrl)
            throws MessengerApiException, MessengerIOException;

    /*
        FILE_ATTACHMENT
     */
    MessengerResponse sendFileAttachment(String recipientId, String fileUrl)
            throws MessengerApiException, MessengerIOException;

    /*
        BINARY_ATTACHMENT
    */
    MessengerResponse sendBinaryAttachment(String recipientId, BinaryAttachment binaryAttachment)
            throws MessengerApiException, MessengerIOException;

    MessengerResponse sendBinaryAttachment(Recipient recipient, NotificationType notificationType,
                                           BinaryAttachment binaryAttachment)
            throws MessengerApiException, MessengerIOException;

    MessengerResponse sendBinaryAttachment(Recipient recipient, NotificationType notificationType,
                                           BinaryAttachment binaryAttachment, List<QuickReply> quickReplies)
            throws MessengerApiException, MessengerIOException;

    MessengerResponse sendBinaryAttachment(Recipient recipient, NotificationType notificationType,
                                           BinaryAttachment binaryAttachment, String metadata)
            throws MessengerApiException, MessengerIOException;

    MessengerResponse sendBinaryAttachment(Recipient recipient, NotificationType notificationType,
                                           BinaryAttachment binaryAttachment, List<QuickReply> quickReplies,
                                           String metadata)
            throws MessengerApiException, MessengerIOException;

    /*
        TEMPLATE
     */
    MessengerResponse sendTemplate(String recipientId, Template template)
            throws MessengerApiException, MessengerIOException;

    MessengerResponse sendTemplate(Recipient recipient, NotificationType notificationType, Template template)
            throws MessengerApiException, MessengerIOException;

    MessengerResponse sendTemplate(Recipient recipient, NotificationType notificationType, Template template,
                                   List<QuickReply> quickReplies)
            throws MessengerApiException, MessengerIOException;

    MessengerResponse sendTemplate(Recipient recipient, NotificationType notificationType, Template template,
                                   String metadata)
            throws MessengerApiException, MessengerIOException;

    MessengerResponse sendTemplate(Recipient recipient, NotificationType notificationType, Template template,
                                   List<QuickReply> quickReplies, String metadata)
            throws MessengerApiException, MessengerIOException;
}