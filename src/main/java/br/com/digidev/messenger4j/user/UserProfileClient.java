package br.com.digidev.user;

import br.com.digidev.exceptions.MessengerApiException;
import br.com.digidev.exceptions.MessengerIOException;

/**
 * @author Max Grabenhorst
 * @since 0.8.0
 */
public interface UserProfileClient {

    UserProfile queryUserProfile(String userId) throws MessengerApiException, MessengerIOException;
}
