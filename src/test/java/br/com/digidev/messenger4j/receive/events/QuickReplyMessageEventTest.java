package br.com.digidev.messenger4j.receive.events;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

/**
 * @author Messenger4J - http://github.com/messenger4j
 */
public class QuickReplyMessageEventTest {

    @Test
    public void shouldHaveACorrectEqualsImplementation() {
        EqualsVerifier.forClass(QuickReplyMessageEvent.class)
                .usingGetClass()
                .verify();

        EqualsVerifier.forClass(QuickReplyMessageEvent.QuickReply.class)
                .usingGetClass()
                .verify();
    }
}