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

import java.io.IOException;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

/**
 * OkHttp-based implementation
 */
class OkHttpIdentifierHttpClient implements IdentifierHttpClient {

    private final OkHttpClient httpClient;
    private final String       baseUrl;

    /**
     * Configures a client facade to access the ID service.
     *
     * @param httpClient
     *            The HTTP client to use (might be reused by other components)
     * @param baseUrl
     *            The base-URL for the ID server to use. Should look like this: `http://some-address.com/whatever/`.
     *            It's required that the URL contains a closing "/"
     */
    OkHttpIdentifierHttpClient(final OkHttpClient httpClient, final String baseUrl) {
        this.httpClient = httpClient;
        this.baseUrl = baseUrl;
    }

    @Override
    public String getNextSequence() {
        return get("sequence");
    }

    @Override
    public String getNextSequenceInBase36() {
        return get("sequence/base36");
    }

    @Override
    public String getNextSequenceInBase64() {
        return get("sequence/base64");
    }

    @Override
    public String getNextUuid() {
        return get("uuid");
    }

    @Override
    public String getNextUuidInBase36() {
        return get("uuid/base36");
    }

    @Override
    public String getNextUuidInBase64() {
        return get("uuid/base64");
    }

    @Override
    public String getNextTimestamp() {
        return get("timestamp");
    }

    @Override
    public String getNextTimestampInBase36() {
        return get("timestamp/base36");
    }

    @Override
    public String getNextTimestampInBase64() {
        return get("timestamp/base64");
    }

    private String get(final String path) {
        final Request request = new Request.Builder()
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
