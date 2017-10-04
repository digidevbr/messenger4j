package br.com.digidev.messenger4j.receive.events;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

/**
 * @author Messenger4J - http://github.com/messenger4j
 */
public class AttachmentMessageEventTest {

    @Test
    public void shouldHaveACorrectEqualsImplementation() {
        EqualsVerifier.forClass(AttachmentMessageEvent.class)
                .usingGetClass()
                .verify();

        EqualsVerifier.forClass(AttachmentMessageEvent.Attachment.class)
                .usingGetClass()
                .verify();

        EqualsVerifier.forClass(AttachmentMessageEvent.BinaryPayload.class)
                .usingGetClass()
                .verify();

        EqualsVerifier.forClass(AttachmentMessageEvent.LocationPayload.class)
                .usingGetClass()
                .verify();

        EqualsVerifier.forClass(AttachmentMessageEvent.UnsupportedPayload.class)
                .usingGetClass()
                .verify();

        EqualsVerifier.forClass(AttachmentMessageEvent.Coordinates.class)
                .usingGetClass()
                .verify();
    }
}