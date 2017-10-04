package br.com.digidev.messenger4j.receive.events;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

/**
 * @author Messenger4J - http://github.com/messenger4j
 */
public class EventTest {

    @Test
    public void shouldHaveACorrectEqualsImplementation() {
        EqualsVerifier.forClass(Event.class)
                .usingGetClass()
                .verify();

        EqualsVerifier.forClass(Event.Entity.class)
                .usingGetClass()
                .verify();
    }
}