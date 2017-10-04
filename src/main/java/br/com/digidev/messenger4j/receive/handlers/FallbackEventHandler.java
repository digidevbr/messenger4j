package br.com.digidev.messenger4j.receive.handlers;

import br.com.digidev.messenger4j.receive.events.FallbackEvent;

/**
 * An implementation of this interface is intended to handle the {@link FallbackEvent}.
 *
 * <p>
 * The {@code FallbackEventHandler} can be used to respond to the user even when the actual event
 * is not supported by this library or when the specific {@link EventHandler} for the actual event is not registered.
 * </p>
 *
 * @author Messenger4J - http://github.com/messenger4j
 * @see EventHandler
 * @see FallbackEvent

 */
public interface FallbackEventHandler extends EventHandler<FallbackEvent> {
}
