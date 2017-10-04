package br.com.digidev.messenger4j.common;

import br.com.digidev.messenger4j.exceptions.MessengerApiException;
import br.com.digidev.messenger4j.exceptions.MessengerIOException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;

/**
 * @author Messenger4J - http://github.com/messenger4j
 * @author Andriy Koretskyy
 */
public abstract class MessengerRestClientAbstract<P, R> {

    private final Gson gson;
    private final JsonParser jsonParser;
    private final MessengerHttpClient httpClient;

    protected MessengerRestClientAbstract(MessengerHttpClient httpClient) {
        this.gson = GsonFactory.createGson();
        this.jsonParser = new JsonParser();
        this.httpClient = httpClient == null ? new DefaultMessengerHttpClient() : httpClient;
    }

    protected R doRequest(MessengerHttpClient.HttpMethod httpMethod, String requestUrl, P payload)
            throws MessengerApiException, MessengerIOException {

        try {
            final String jsonBody = payload == null ? null : this.gson.toJson(payload);
            final MessengerHttpClient.HttpResponse httpResponse = this.httpClient.execute(httpMethod, requestUrl, jsonBody);
            final JsonObject responseJsonObject = this.jsonParser.parse(httpResponse.getBody()).getAsJsonObject();

            if (httpResponse.getStatusCode() >= 200 && httpResponse.getStatusCode() < 300) {
                return responseFromJson(responseJsonObject);
            } else {
                throw MessengerApiException.fromJson(responseJsonObject);
            }
        } catch (IOException e) {
            throw new MessengerIOException(e);
        }
    }

    protected abstract R responseFromJson(JsonObject responseJsonObject);

}
