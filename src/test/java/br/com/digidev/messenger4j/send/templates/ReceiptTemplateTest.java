package br.com.digidev.messenger4j.send.templates;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

/**
 * @author Messenger4J - http://github.com/messenger4j
 */
public class ReceiptTemplateTest {

    @Test
    public void shouldHaveACorrectEqualsImplementation() {
        EqualsVerifier.forClass(ReceiptTemplate.class)
                .usingGetClass()
                .verify();

        EqualsVerifier.forClass(ReceiptTemplate.Adjustment.class)
                .usingGetClass()
                .verify();

        EqualsVerifier.forClass(ReceiptTemplate.Element.class)
                .usingGetClass()
                .verify();

        EqualsVerifier.forClass(ReceiptTemplate.ShippingAddress.class)
                .usingGetClass()
                .verify();

        EqualsVerifier.forClass(ReceiptTemplate.Summary.class)
                .usingGetClass()
                .verify();
    }
}