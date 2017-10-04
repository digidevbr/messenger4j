package br.com.digidev.messenger4j.receive.handlers;

import br.com.digidev.messenger4j.receive.events.AccountLinkingEvent;

/**
 * An implementation of this interface is intended to handle the {@link AccountLinkingEvent}.
 *
 * @author Messenger4J - http://github.com/messenger4j
 * @see EventHandler
 * @see AccountLinkingEvent
 */
public interface AccountLinkingEventHandler extends EventHandler<AccountLinkingEvent> {
}
