package br.com.digidev.messenger4j.receive.handlers;

import br.com.digidev.messenger4j.receive.events.TextMessageEvent;

/**
 * An implementation of this interface is intended to handle the {@link TextMessageEvent}.
 *
 * @author Messenger4J - http://github.com/messenger4j
 * @see EventHandler
 * @see TextMessageEvent
 */
public interface TextMessageEventHandler extends EventHandler<TextMessageEvent> {
}
