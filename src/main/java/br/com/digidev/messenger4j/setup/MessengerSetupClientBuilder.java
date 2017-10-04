package br.com.digidev.messenger4j.setup;

import br.com.digidev.messenger4j.common.MessengerHttpClient;
import br.com.digidev.messenger4j.internal.PreConditions;

/**
 * @author Andriy Koretskyy
 */
public final class MessengerSetupClientBuilder {

    final String pageAccessToken;
    MessengerHttpClient httpClient;

    public MessengerSetupClientBuilder(String pageAccessToken) {
        PreConditions.notNullOrBlank(pageAccessToken, "pageAccessToken");
        this.pageAccessToken = pageAccessToken;
    }

    public MessengerSetupClientBuilder httpClient(MessengerHttpClient messengerHttpClient) {
        this.httpClient = messengerHttpClient;
        return this;
    }

    public MessengerSetupClient build() {
        return new MessengerSetupClientImpl(this);
    }
}