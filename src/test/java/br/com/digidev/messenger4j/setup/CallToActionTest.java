package br.com.digidev.messenger4j.setup;

import nl.jqno.equalsverifier.EqualsVerifier;

/**
 * @author Messenger4J - http://github.com/messenger4j
 */
public class CallToActionTest {

    //TODO: check IllegalArgumentException: Cannot inject classes into the bootstrap class loader
    //@Test
    public void shouldHaveACorrectEqualsImplementation() {
        EqualsVerifier.forClass(CallToAction.class)
                .usingGetClass()
                .verify();
    }
}