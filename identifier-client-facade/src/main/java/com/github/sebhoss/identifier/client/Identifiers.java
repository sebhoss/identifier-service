package com.github.sebhoss.identifier.client;

import com.squareup.okhttp.OkHttpClient;

/**
 * Constructs new facades to use. In general, those are thread-safe, so there is no reason to construct multiple facades, but it won't really hurt
 * either (extra memory wasted).
 */
public final class Identifiers {

    private Identifiers() {
        // factory class
    }

    /**
     * @return A new client facade using the default options
     */
    public static IdentifierFacade facade() {
        return facade("http://id.xn--ho-hia.de/");
    }

    /**
     * @param baseUrl The remote base-URL to talk to. Since this is used as the basis to construct URLs, the given base-URL is required to end in a "/"
     * @return A new client facade which talks to the given baseUrl
     */
    public static IdentifierFacade facade(final String baseUrl) {
        return facade(new OkHttpClient(), baseUrl);
    }

    /**
     * @param client The HTTP client to use
     * @param baseUrl The remote base-URL to talk to. Since this is used as the basis to construct URLs, the given base-URL is required to end in a "/"
     * @return A new client facade which talks to the given baseUrl using the given HTTP client
     */
    public static IdentifierFacade facade(final OkHttpClient client, final String baseUrl) {
        return new IdentifierFacadeImplementation(client, baseUrl);
    }

}
