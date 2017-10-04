package br.com.digidev.messenger4j.send.buttons;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

/**
 * @author Messenger4J - http://github.com/messenger4j
 */
public class CallButtonTest {

    @Test
    public void shouldHaveACorrectEqualsImplementation() {
        EqualsVerifier.forClass(CallButton.class)
                .usingGetClass()
                .verify();
    }
}