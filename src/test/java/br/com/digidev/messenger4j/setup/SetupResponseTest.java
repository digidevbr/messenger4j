package br.com.digidev.messenger4j.setup;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

/**
 * @author Messenger4J - http://github.com/messenger4j
 */
public class SetupResponseTest {

    @Test
    public void shouldHaveACorrectEqualsImplementation() {
        EqualsVerifier.forClass(SetupResponse.class)
                .usingGetClass()
                .verify();
    }
}