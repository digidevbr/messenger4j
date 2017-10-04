package br.com.digidev.messenger4j.receive.handlers;

import br.com.digidev.messenger4j.receive.events.MessageDeliveredEvent;

/**
 * An implementation of this interface is intended to handle the {@link MessageDeliveredEvent}.
 *
 * @author Messenger4J - http://github.com/messenger4j
 * @see EventHandler
 * @see MessageDeliveredEvent
 */
public interface MessageDeliveredEventHandler extends EventHandler<MessageDeliveredEvent> {
}
