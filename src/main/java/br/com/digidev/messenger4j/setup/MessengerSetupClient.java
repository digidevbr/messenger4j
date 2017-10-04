package br.com.digidev.messenger4j.setup;

import br.com.digidev.messenger4j.exceptions.MessengerApiException;
import br.com.digidev.messenger4j.exceptions.MessengerIOException;

import java.util.List;

/**
 * @author Andriy Koretskyy
 */
public interface MessengerSetupClient {

    //Allowed constants:
    // {{user_first_name}}
    // {{user_last_name}}
    // {{user_full_name}}
    SetupResponse setupWelcomeMessage(String greeting) throws MessengerApiException, MessengerIOException;

    SetupResponse resetWelcomeMessage() throws MessengerApiException, MessengerIOException;

    SetupResponse setupStartButton(String startPayload) throws MessengerApiException, MessengerIOException;

    SetupResponse removeStartButton() throws MessengerApiException, MessengerIOException;

    SetupResponse setupPersistentMenu(List<CallToAction> menuItems) throws MessengerApiException, MessengerIOException;

    SetupResponse removePersistentMenu() throws MessengerApiException, MessengerIOException;

}
