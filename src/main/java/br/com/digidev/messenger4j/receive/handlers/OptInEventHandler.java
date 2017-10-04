package br.com.digidev.messenger4j.receive.handlers;

import br.com.digidev.messenger4j.receive.events.OptInEvent;

/**
 * An implementation of this interface is intended to handle the {@link OptInEvent}.
 *
 * @author Max Grabenhorst
 * @since 0.6.0
 * @see EventHandler
 * @see OptInEvent
 */
public interface OptInEventHandler extends EventHandler<OptInEvent> {
}
