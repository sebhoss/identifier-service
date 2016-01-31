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
