/*
 * This file is part of identifier-service. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of identifier-service,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package com.github.sebhoss.identifier.usecases;

import static com.github.sebhoss.identifier.testsupport.UuidMatcher.isValidUUID;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import com.github.sebhoss.identifier.testsupport.AbstractIntegrationTest;

import org.junit.Test;
import org.springframework.http.ResponseEntity;

/**
 * Integration test for {@link UUIDs}.
 */
@SuppressWarnings("nls")
public class UUIDsIT extends AbstractIntegrationTest {

    /**
     * Ensures that an UUID can be retrieved from <code>/uuids/uuid</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetUuid() throws Exception {
        final ResponseEntity<String> response = fetchString("/uuids/uuid");
        assertThat(response.getBody(), isValidUUID());
    }

    /**
     * Ensures that an UUID in Base36 can be retrieved from <code>/uuids/base36</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetUuidInBase36() throws Exception {
        final ResponseEntity<String> response = fetchString("/uuids/base36");
        assertNotNull(response.getBody());
    }

    /**
     * Ensures that an UUID in Base62 can be retrieved from <code>/uuids/base62</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetUuidInBase62() throws Exception {
        final ResponseEntity<String> response = fetchString("/uuids/base62");
        assertNotNull(response.getBody());
    }

    /**
     * Ensures that an UUID in Base64 can be retrieved from <code>/uuids/base64</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetUuidInBase64() throws Exception {
        final ResponseEntity<String> response = fetchString("/uuids/base64");
        assertNotNull(response.getBody());
    }

    /**
     * Ensures that an UUID as HashId can be retrieved from <code>/uuids/hashid</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetUuidAsHashId() throws Exception {
        final ResponseEntity<String> response = fetchString("/uuids/hashid");
        assertNotNull(response.getBody());
    }

}
