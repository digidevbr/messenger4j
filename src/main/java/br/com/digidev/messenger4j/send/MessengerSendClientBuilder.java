package br.com.digidev.messenger4j.send;

import br.com.digidev.messenger4j.internal.PreConditions;
import br.com.digidev.messenger4j.common.MessengerHttpClient;

/**
 * @author Messenger4J - http://github.com/messenger4j
 */
public final class MessengerSendClientBuilder {

    final String pageAccessToken;
    MessengerHttpClient httpClient;

    public MessengerSendClientBuilder(String pageAccessToken) {
        PreConditions.notNullOrBlank(pageAccessToken, "pageAccessToken");
        this.pageAccessToken = pageAccessToken;
    }

    public MessengerSendClientBuilder httpClient(MessengerHttpClient messengerHttpClient) {
        this.httpClient = messengerHttpClient;
        return this;
    }

    public MessengerSendClient build() {
        return new MessengerSendClientImpl(this);
    }
}