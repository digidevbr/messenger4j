package br.com.digidev.messenger4j.receive.handlers;

import br.com.digidev.messenger4j.receive.events.MessageReadEvent;

/**
 * An implementation of this interface is intended to handle the {@link MessageReadEvent}.
 *
 * @author Max Grabenhorst
 * @since 0.6.0
 * @see EventHandler
 * @see MessageReadEvent
 */
public interface MessageReadEventHandler extends EventHandler<MessageReadEvent> {
}
