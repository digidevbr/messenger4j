package br.com.digidev.receive.handlers;

import br.com.digidev.receive.events.AccountLinkingEvent;

/**
 * An implementation of this interface is intended to handle the {@link AccountLinkingEvent}.
 *
 * @author Max Grabenhorst
 * @since 0.6.0
 * @see EventHandler
 * @see AccountLinkingEvent
 */
public interface AccountLinkingEventHandler extends EventHandler<AccountLinkingEvent> {
}
