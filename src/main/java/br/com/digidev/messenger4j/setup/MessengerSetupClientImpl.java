package br.com.digidev.messenger4j.setup;

import br.com.digidev.messenger4j.common.MessengerHttpClient;
import br.com.digidev.messenger4j.common.MessengerRestClientAbstract;
import br.com.digidev.messenger4j.exceptions.MessengerApiException;
import br.com.digidev.messenger4j.exceptions.MessengerIOException;
import com.google.gson.JsonObject;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Andriy Koretskyy
 * @since 0.8.0
 */
final class MessengerSetupClientImpl extends MessengerRestClientAbstract<SetupPayload, SetupResponse>
        implements MessengerSetupClient {

    private static final String FB_GRAPH_API_URL = "https://graph.facebook.com/v2.8/me/thread_settings?access_token=%s";

    private final Logger logger = LoggerFactory.getLogger(MessengerSetupClientImpl.class);

    private final String requestUrl;

    MessengerSetupClientImpl(MessengerSetupClientBuilder builder) {
        super(builder.httpClient);
        this.requestUrl = String.format(FB_GRAPH_API_URL, builder.pageAccessToken);
        logger.debug("{} initialized successfully.", MessengerSetupClientImpl.class.getSimpleName());
    }

    @Override
    public SetupResponse setupWelcomeMessage(String greeting)
            throws MessengerApiException, MessengerIOException {
        final SetupPayload payload = SetupPayload.newBuilder()
                .settingType(SettingType.GREETING)
                .greeting(greeting)
                .build();

        return sendPayload(MessengerHttpClient.HttpMethod.POST, payload);
    }

    @Override
    public SetupResponse resetWelcomeMessage() throws MessengerApiException, MessengerIOException {
        final SetupPayload payload = SetupPayload.newBuilder()
                .settingType(SettingType.GREETING)
                .build();

        return sendPayload(MessengerHttpClient.HttpMethod.DELETE, payload);
    }

    @Override
    public SetupResponse setupStartButton(String startPayload)
            throws MessengerApiException, MessengerIOException {
        final SetupPayload payload = SetupPayload.newBuilder()
                .settingType(SettingType.CALL_TO_ACTIONS)
                .threadState(ThreadState.NEW_THREAD)
                .payload(startPayload)
                .build();

        return sendPayload(MessengerHttpClient.HttpMethod.POST, payload);
    }

    @Override
    public SetupResponse removeStartButton() throws MessengerApiException, MessengerIOException {
        final SetupPayload payload = SetupPayload.newBuilder()
                .settingType(SettingType.CALL_TO_ACTIONS)
                .threadState(ThreadState.NEW_THREAD)
                .build();

        return sendPayload(MessengerHttpClient.HttpMethod.DELETE, payload);
    }

    @Override
    public SetupResponse setupPersistentMenu(List<CallToAction> menuItems) throws MessengerApiException, MessengerIOException {
        final SetupPayload payload = SetupPayload.newBuilder()
                .settingType(SettingType.CALL_TO_ACTIONS)
                .threadState(ThreadState.EXISTING_THREAD)
                .addMenuItems(menuItems)
                .build();

        return sendPayload(MessengerHttpClient.HttpMethod.POST, payload);
    }

    @Override
    public SetupResponse removePersistentMenu() throws MessengerApiException, MessengerIOException {
        final SetupPayload payload = SetupPayload.newBuilder()
                .settingType(SettingType.CALL_TO_ACTIONS)
                .threadState(ThreadState.EXISTING_THREAD)
                .build();

        return sendPayload(MessengerHttpClient.HttpMethod.DELETE, payload);
    }

    private SetupResponse sendPayload(MessengerHttpClient.HttpMethod httpMethod, SetupPayload payload)
            throws MessengerApiException, MessengerIOException {

        return doRequest(httpMethod, this.requestUrl, payload);
    }

    @Override
    protected SetupResponse responseFromJson(JsonObject responseJsonObject) {
        return SetupResponse.fromJson(responseJsonObject);
    }
}
