package br.com.digidev.receive.handlers;

import br.com.digidev.receive.events.OptInEvent;

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
