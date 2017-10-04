package br.com.digidev.receive.handlers;

import br.com.digidev.receive.events.EchoMessageEvent;

/**
 * An implementation of this interface is intended to handle the {@link EchoMessageEvent}.
 *
 * @author Max Grabenhorst
 * @since 0.6.0
 * @see EventHandler
 * @see EchoMessageEvent
 */
public interface EchoMessageEventHandler extends EventHandler<EchoMessageEvent> {
}
