package br.com.digidev.receive.handlers;

import br.com.digidev.receive.MessengerReceiveClient;
import br.com.digidev.receive.MessengerReceiveClientBuilder;
import br.com.digidev.receive.events.Event;

/**
 * This <b>internal</b> interface is the base interface for event-specific {@code EventHandler} interfaces.
 *
 * <p>
 * For each supported {@link Event} there is a corresponding handler interface available.<br>
 * These interfaces can be used to define how to handle the events.
 * </p>
 *
 * <p>
 * For each individual event you can register an implementation of the event-specific {@code EventHandler}
 * when creating a {@link MessengerReceiveClient} using the {@link MessengerReceiveClientBuilder}.<br>
 * This implementation is called when the according event occurs.
 * </p>
 *
 * @param <E> the {@link Event} that is handled by the {@code EventHandler}
 *
 * @author Max Grabenhorst
 * @since 0.6.0
 * @see Event
 * @see MessengerReceiveClientBuilder
 */
public interface EventHandler<E extends Event> {

    void handle(E event);
}