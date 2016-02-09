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
