/*
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 *
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * For more information, please refer to <http://unlicense.org>
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
