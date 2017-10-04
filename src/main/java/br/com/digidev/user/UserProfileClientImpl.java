package br.com.digidev.user;

import br.com.digidev.common.MessengerHttpClient;
import br.com.digidev.exceptions.MessengerApiException;
import br.com.digidev.exceptions.MessengerIOException;
import br.com.digidev.common.MessengerRestClientAbstract;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Max Grabenhorst
 * @since 0.8.0
 */
final class UserProfileClientImpl extends MessengerRestClientAbstract<Void, UserProfile>
        implements UserProfileClient {

    private static final String FB_GRAPH_API_URL = "https://graph.facebook.com/v2.8/%s?fields=first_name," +
            "last_name,profile_pic,locale,timezone,gender&access_token=%s";

    private final Logger logger = LoggerFactory.getLogger(UserProfileClientImpl.class);

    private final String pageAccessToken;

    UserProfileClientImpl(UserProfileClientBuilder builder) {
        super(builder.httpClient);
        this.pageAccessToken = builder.pageAccessToken;
        logger.debug("{} initialized successfully.", UserProfileClientImpl.class.getSimpleName());
    }

    @Override
    public UserProfile queryUserProfile(String userId) throws MessengerApiException, MessengerIOException {
        final String requestUrl = String.format(FB_GRAPH_API_URL, userId, pageAccessToken);
        return doRequest(MessengerHttpClient.HttpMethod.GET, requestUrl, null);
    }

    @Override
    protected UserProfile responseFromJson(JsonObject responseJsonObject) {
        return UserProfile.fromJson(responseJsonObject);
    }
}
