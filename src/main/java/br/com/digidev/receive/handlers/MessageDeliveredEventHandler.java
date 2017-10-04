package br.com.digidev.receive.handlers;

import br.com.digidev.receive.events.MessageDeliveredEvent;

/**
 * An implementation of this interface is intended to handle the {@link MessageDeliveredEvent}.
 *
 * @author Max Grabenhorst
 * @since 0.6.0
 * @see EventHandler
 * @see MessageDeliveredEvent
 */
public interface MessageDeliveredEventHandler extends EventHandler<MessageDeliveredEvent> {
}
