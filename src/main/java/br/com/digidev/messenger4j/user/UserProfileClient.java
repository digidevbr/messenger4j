package br.com.digidev.messenger4j.user;

import br.com.digidev.messenger4j.exceptions.MessengerApiException;
import br.com.digidev.messenger4j.exceptions.MessengerIOException;

/**
 * @author Messenger4J - http://github.com/messenger4j
 */
public interface UserProfileClient {

    UserProfile queryUserProfile(String userId) throws MessengerApiException, MessengerIOException;
}
