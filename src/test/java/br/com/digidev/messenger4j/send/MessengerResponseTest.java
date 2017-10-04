package br.com.digidev.send;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

/**
 * @author Max Grabenhorst
 * @since 0.6.0
 */
public class MessengerResponseTest {

    @Test
    public void shouldHaveACorrectEqualsImplementation() {
        EqualsVerifier.forClass(MessengerResponse.class)
                .usingGetClass()
                .verify();
    }
}