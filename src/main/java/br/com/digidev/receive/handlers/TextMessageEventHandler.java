package br.com.digidev.receive.handlers;

import br.com.digidev.receive.events.TextMessageEvent;

/**
 * An implementation of this interface is intended to handle the {@link TextMessageEvent}.
 *
 * @author Max Grabenhorst
 * @since 0.6.0
 * @see EventHandler
 * @see TextMessageEvent
 */
public interface TextMessageEventHandler extends EventHandler<TextMessageEvent> {
}
