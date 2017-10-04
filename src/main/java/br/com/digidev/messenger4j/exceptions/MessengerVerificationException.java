package br.com.digidev.messenger4j.exceptions;

/**
 * Thrown to indicate that a verification failed.
 *
 * <p>
 * For example verification of the payload signature.
 * </p>
 *
 * @author Messenger4J - http://github.com/messenger4j
 */
public final class MessengerVerificationException extends Exception {

    public MessengerVerificationException(String message) {
        super(message);
    }
}