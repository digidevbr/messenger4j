package br.com.digidev.messenger4j.user;

import br.com.digidev.messenger4j.exceptions.MessengerApiException;
import br.com.digidev.messenger4j.exceptions.MessengerIOException;

/**
 * @author Max Grabenhorst
 * @since 0.8.0
 */
public interface UserProfileClient {

    UserProfile queryUserProfile(String userId) throws MessengerApiException, MessengerIOException;
}
