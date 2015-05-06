/*
 * This file is part of identifier-service. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of identifier-service,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package com.github.sebhoss.identifier.client;

import java.io.IOException;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

/**
 * OkHttp-based implementation
 */
@SuppressWarnings("nls")
class OkHttpIdentifierClient implements IdentifierClient {

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
    OkHttpIdentifierClient(final OkHttpClient httpClient, final String baseUrl) {
        this.httpClient = httpClient;
        this.baseUrl = baseUrl;
    }

    @Override
    public String getNextSequence() {
        return get("sequences/sequence");
    }

    @Override
    public String getNextSequenceInBase36() {
        return get("sequences/base36");
    }

    @Override
    public String getNextSequenceInBase62() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getNextSequenceInBase64() {
        return get("sequences/base64");
    }

    @Override
    public String getNextSequenceAsHashId() {
        // TODO Auto-generated method stub
        return null;
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
    public String getNextTimestampInBase62() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getNextTimestampInBase64() {
        return get("timestamp/base64");
    }

    @Override
    public String getNextTimestampAsHashId() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getNextUuid() {
        return get("uuids/uuid");
    }

    @Override
    public String getNextUuidInBase36() {
        return get("uuid/base36");
    }

    @Override
    public String getNextUuidInBase62() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getNextUuidInBase64() {
        return get("uuid/base64");
    }

    @Override
    public String getNextUuidAsHashId() {
        // TODO Auto-generated method stub
        return null;
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
