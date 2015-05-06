/*
 * This file is part of identifier-service. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of identifier-service,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package com.github.sebhoss.identifier.usecases;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import com.github.sebhoss.identifier.testsupport.AbstractIntegrationTest;

import org.junit.Test;
import org.springframework.http.ResponseEntity;

/**
 * Integration test for {@link Sequences}.
 */
@SuppressWarnings("nls")
public class SequencesIT extends AbstractIntegrationTest {

    /**
     * Ensures that a sequence number can be retrieved from <code>/sequences/sequence</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetSequence() throws Exception {
        final ResponseEntity<String> response = fetchString("/sequences/sequence");
        assertThat(response.getBody(), equalTo("0"));
    }

    /**
     * Ensures that a sequence number in Base36 can be retrieved from <code>/sequences/base36</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetSequenceInBase36() throws Exception {
        final ResponseEntity<String> response = fetchString("/sequences/base36");
        assertThat(response.getBody(), equalTo("2"));
    }

    /**
     * Ensures that a sequence number in Base62 can be retrieved from <code>/sequences/base62</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetSequenceInBase62() throws Exception {
        final ResponseEntity<String> response = fetchString("/sequences/base62");
        assertThat(response.getBody(), equalTo("d"));
    }

    /**
     * Ensures that a sequence number in Base64 can be retrieved from <code>/sequences/base64</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetSequenceInBase64() throws Exception {
        final ResponseEntity<String> response = fetchString("/sequences/base64");
        assertThat(response.getBody(), equalTo("NA"));
    }

    /**
     * Ensures that a sequence number as HashId can be retrieved from <code>/sequences/hashid</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetSequenceAsHashId() throws Exception {
        final ResponseEntity<String> response = fetchString("/sequences/hashid");
        assertThat(response.getBody(), equalTo("lQ"));
    }

}
