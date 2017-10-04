package br.com.digidev.messenger4j.send;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

/**
 * @author Messenger4J - http://github.com/messenger4j
 */
public class BinaryAttachmentTest {

    @Test
    public void shouldHaveACorrectEqualsImplementation() {
        EqualsVerifier.forClass(BinaryAttachment.class)
                .usingGetClass()
                .verify();

        EqualsVerifier.forClass(BinaryAttachment.Payload.class)
                .usingGetClass()
                .verify();
    }
}