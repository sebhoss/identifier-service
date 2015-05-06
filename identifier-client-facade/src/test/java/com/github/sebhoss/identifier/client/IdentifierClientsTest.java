/*
 * This file is part of identifier-service. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of identifier-service,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package com.github.sebhoss.identifier.client;

import com.squareup.okhttp.OkHttpClient;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for {@link IdentifierClients}.
 */
@SuppressWarnings("static-method")
public class IdentifierClientsTest {

    /**
     * Ensures that a default HTTP client can be built.
     */
    @Test
    public void shouldBuildDefaultHttpClient() {
        // given
        IdentifierClient client;

        // when
        client = IdentifierClients.http();

        // then
        Assert.assertNotNull(client);
    }

    /**
     * Ensures that a HTTP client with a custom URL can be built.
     */
    @Test
    public void shouldBuildHttpClientWithCustomURL() {
        // given
        final String url = "example.com"; //$NON-NLS-1$

        // when
        final IdentifierClient client = IdentifierClients.http(url);

        // then
        Assert.assertNotNull(client);
    }

    /**
     * Ensures that a custom HTTP client with a custom URL can be built.
     */
    @Test
    public void shouldBuildCustomHttpClientWithCustomURL() {
        // given
        final OkHttpClient ok = new OkHttpClient();
        final String url = "example.com"; //$NON-NLS-1$

        // when
        final IdentifierClient client = IdentifierClients.http(ok, url);

        // then
        Assert.assertNotNull(client);
    }

}
