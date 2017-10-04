package br.com.digidev.messenger4j.exceptions;

/**
 * Thrown to indicate that a Messenger Platform I/O operation failed or was interrupted.
 *
 * @author Messenger4J - http://github.com/messenger4j
 */
public final class MessengerIOException extends Exception {

    public MessengerIOException(Throwable cause) {
        super(cause);
    }
}