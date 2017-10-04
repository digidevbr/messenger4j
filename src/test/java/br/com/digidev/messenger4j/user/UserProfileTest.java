package br.com.digidev.messenger4j.user;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

/**
 * @author Messenger4J - http://github.com/messenger4j
 */
public class UserProfileTest {

    @Test
    public void shouldHaveACorrectEqualsImplementation() {
        EqualsVerifier.forClass(UserProfile.class)
                .usingGetClass()
                .verify();
    }
}