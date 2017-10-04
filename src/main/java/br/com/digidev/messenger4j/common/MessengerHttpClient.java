package br.com.digidev.messenger4j.common;

import java.io.IOException;

/**
 * @author Messenger4J - http://github.com/messenger4j
 */
public interface MessengerHttpClient {

    /**
     * @author Andriy Koretskyy
     */
    enum HttpMethod {
        GET,
        POST,
        DELETE
    }

    /**
     */
    HttpResponse execute(HttpMethod httpMethod, String url, String jsonBody) throws IOException;

    /**
     * @author Messenger4J - http://github.com/messenger4j
     */
    final class HttpResponse {

        private final int statusCode;
        private final String body;

        public HttpResponse(int statusCode, String body) {
            this.statusCode = statusCode;
            this.body = body;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public String getBody() {
            return body;
        }
    }
}