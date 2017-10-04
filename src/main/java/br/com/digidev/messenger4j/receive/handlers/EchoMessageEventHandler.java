package br.com.digidev.messenger4j.receive.handlers;

import br.com.digidev.messenger4j.receive.events.EchoMessageEvent;

/**
 * An implementation of this interface is intended to handle the {@link EchoMessageEvent}.
 *
 * @author Messenger4J - http://github.com/messenger4j
 * @see EventHandler
 * @see EchoMessageEvent
 */
public interface EchoMessageEventHandler extends EventHandler<EchoMessageEvent> {
}
