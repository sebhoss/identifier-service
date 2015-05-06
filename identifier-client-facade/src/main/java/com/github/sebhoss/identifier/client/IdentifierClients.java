/*
 * This file is part of identifier-service. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of identifier-service,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package com.github.sebhoss.identifier.client;

import com.squareup.okhttp.OkHttpClient;

/**
 * Constructs new facades to use. In general, those are thread-safe, so there is no reason to construct multiple
 * facades, but it won't really hurt either (except some extra memory wasted).
 */
public final class IdentifierClients {

    private IdentifierClients() {
        // factory class
    }

    /**
     * @return A new client facade using the default options
     */
    public static IdentifierClient http() {
        return http("https://id.xn--ho-hia.de/"); //$NON-NLS-1$
    }

    /**
     * @param baseUrl
     *            The remote base-URL to talk to. Since this is used as the basis to construct URLs, the given base-URL
     *            is required to end in a "/"
     * @return A new client facade which talks to the given baseUrl
     */
    public static IdentifierClient http(final String baseUrl) {
        return http(new OkHttpClient(), baseUrl);
    }

    /**
     * @param client
     *            The HTTP client to use
     * @param baseUrl
     *            The remote base-URL to talk to. Since this is used as the basis to construct URLs, the given base-URL
     *            is required to end in a "/"
     * @return A new client facade which talks to the given baseUrl using the given HTTP client
     */
    public static IdentifierClient http(final OkHttpClient client, final String baseUrl) {
        return new OkHttpIdentifierClient(client, baseUrl);
    }

}
