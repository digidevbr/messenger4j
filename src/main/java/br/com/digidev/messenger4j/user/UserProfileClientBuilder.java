package br.com.digidev.user;

import br.com.digidev.common.MessengerHttpClient;
import br.com.digidev.internal.PreConditions;

/**
 * @author Max Grabenhorst
 * @since 0.8.0
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