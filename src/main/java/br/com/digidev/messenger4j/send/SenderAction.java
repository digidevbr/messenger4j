package br.com.digidev.messenger4j.send;

/**
 * @author Messenger4J - http://github.com/messenger4j

 */
public enum SenderAction {

    /**
     * Mark last message as read.
     */
    MARK_SEEN,

    /**
     * Turn typing indicators on.
     * Typing indicators are automatically turned off after 20 seconds.
     */
    TYPING_ON,

    /**
     * Turn typing indicators off.
     */
    TYPING_OFF
}