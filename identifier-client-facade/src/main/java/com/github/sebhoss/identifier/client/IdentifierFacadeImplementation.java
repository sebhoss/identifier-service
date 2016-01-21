package com.github.sebhoss.identifier.client;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import java.io.IOException;

/**
 * OkHttp-based implementation
 */
class IdentifierFacadeImplementation implements IdentifierFacade {

    private final OkHttpClient httpClient;
    private final String baseUrl;

    /**
     * Configures a client facade to access the ID service.
     *
     * @param httpClient The HTTP client to use (might be reused by other components)
     * @param baseUrl The base-URL for the ID server to use. Should look like this: `http://some-address.com/whatever/`. It's required that the URL
     * contains a closing "/"
     */
    IdentifierFacadeImplementation(final OkHttpClient httpClient, final String baseUrl) {
        this.httpClient = httpClient;
        this.baseUrl = baseUrl;
    }

    public String getNextSequence() {
        return get("sequence");
    }

    public String getNextSequenceInBase36() {
        return get("sequence-in-base36");
    }

    public String getNextSequenceInBase64() {
        return get("sequence-in-base64");
    }

    public String getNextUuid() {
        return get("uuid");
    }

    public String getNextUuidInBase36() {
        return get("uuid-in-base36");
    }

    public String getNextUuidInBase64() {
        return get("uuid-in-base64");
    }

    public String getNextTimestamp() {
        return get("timestamp");
    }

    public String getNextTimestampInBase36() {
        return get("timestamp-in-base36");
    }

    public String getNextTimestampInBase64() {
        return get("timestamp-in-base64");
    }

    private String get(final String path) {
        Request request = new Request.Builder()
                .get()
                .url(baseUrl + path)
                .build();

        try {
            return httpClient.newCall(request).execute().body().string();
        } catch (final IOException exception) {
            throw new IllegalStateException(exception);
        }
    }

}
