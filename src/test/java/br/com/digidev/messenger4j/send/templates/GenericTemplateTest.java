package br.com.digidev.messenger4j.send.templates;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

/**
 * @author Messenger4J - http://github.com/messenger4j
 */
public class GenericTemplateTest {

    @Test
    public void shouldHaveACorrectEqualsImplementation() {
        EqualsVerifier.forClass(GenericTemplate.class)
                .usingGetClass()
                .verify();

        EqualsVerifier.forClass(GenericTemplate.Element.class)
                .usingGetClass()
                .verify();
    }
}