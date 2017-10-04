package br.com.digidev.messenger4j.user;

import br.com.digidev.messenger4j.common.MessengerHttpClient;
import br.com.digidev.messenger4j.internal.PreConditions;

/**
 * @author Messenger4J - http://github.com/messenger4j
 */
public final class UserProfileClientBuilder {

    final String pageAccessToken;
    MessengerHttpClient httpClient;

    public UserProfileClientBuilder(String pageAccessToken) {
        PreConditions.notNullOrBlank(pageAccessToken, "pageAccessToken");
        this.pageAccessToken = pageAccessToken;
    }

    public UserProfileClientBuilder httpClient(MessengerHttpClient messengerHttpClient) {
        this.httpClient = messengerHttpClient;
        return this;
    }

    public UserProfileClient build() {
        return new UserProfileClientImpl(this);
    }
}