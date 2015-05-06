/*
 * This file is part of identifier-service. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of identifier-service,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package com.github.sebhoss.identifier.usecases;

import static org.junit.Assert.assertNotNull;

import com.github.sebhoss.identifier.testsupport.AbstractIntegrationTest;

import org.junit.Test;
import org.springframework.http.ResponseEntity;

/**
 * Integration test for {@link Timestamps}.
 */
@SuppressWarnings("nls")
public class TimestampsIT extends AbstractIntegrationTest {

    /**
     * Ensures that the current timestamp can be retrieved from <code>/timestamps/timestamp</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetTimestamp() throws Exception {
        final ResponseEntity<String> response = fetchString("/timestamps/timestamp");
        assertNotNull(response.getBody());
    }

    /**
     * Ensures that the current timestamp in Base36 can be retrieved from <code>/timestamps/base36</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetTimestampInBase36() throws Exception {
        final ResponseEntity<String> response = fetchString("/timestamps/base36");
        assertNotNull(response.getBody());
    }

    /**
     * Ensures that the current timestamp in Base62 can be retrieved from <code>/timestamps/base62</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetTimestampInBase62() throws Exception {
        final ResponseEntity<String> response = fetchString("/timestamps/base62");
        assertNotNull(response.getBody());
    }

    /**
     * Ensures that the current timestamp in Base64 can be retrieved from <code>/timestamps/base64</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetTimestampInBase64() throws Exception {
        final ResponseEntity<String> response = fetchString("/timestamps/base64");
        assertNotNull(response.getBody());
    }

    /**
     * Ensures that the current timestamp as HashId can be retrieved from <code>/timestamps/hashid</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetTimestampAsHashId() throws Exception {
        final ResponseEntity<String> response = fetchString("/timestamps/hashid");
        assertNotNull(response.getBody());
    }

}
