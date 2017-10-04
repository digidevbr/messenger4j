package br.com.digidev.messenger4j.send.buttons;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

/**
 * @author Max Grabenhorst
 * @since 0.6.0
 */
public class ButtonTest {

    @Test
    public void shouldHaveACorrectEqualsImplementation() {
        EqualsVerifier.forClass(Button.class)
                .usingGetClass()
                .verify();
    }

}