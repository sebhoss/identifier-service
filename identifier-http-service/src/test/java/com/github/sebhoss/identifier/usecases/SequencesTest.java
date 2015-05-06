/*
 * This file is part of identifier-service. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of identifier-service,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package com.github.sebhoss.identifier.usecases;

import com.github.sebhoss.identifier.testsupport.AbstractMockMvcTest;

import org.junit.Test;

/**
 * Unit test for {@link Sequences}.
 */
@SuppressWarnings("nls")
public class SequencesTest extends AbstractMockMvcTest<Sequences, Sequences.API> {

    /**
     * Provides the superclass with required infrastructure.
     */
    public SequencesTest() {
        super(Sequences::new, Sequences.API.class);
    }

    /**
     * Ensures that a sequence number can be retrieved from <code>/sequences/sequence</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetSequence() throws Exception {
        // given
        expectedResult = "12345";

        // when
        supplier = api::nextSequence;

        // then
        requestAndVerify("/sequences/sequence");
    }

    /**
     * Ensures that a sequence number in Base36 can be retrieved from <code>/sequences/base36</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetSequenceInBase36() throws Exception {
        // given
        expectedResult = "9ix";

        // when
        supplier = api::nextSequenceInBase36;

        // then
        requestAndVerify("/sequences/base36");
    }

    /**
     * Ensures that a sequence number in Base62 can be retrieved from <code>/sequences/base62</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetSequenceInBase62() throws Exception {
        // given
        expectedResult = "zt";

        // when
        supplier = api::nextSequenceInBase62;

        // then
        requestAndVerify("/sequences/base62");
    }

    /**
     * Ensures that a sequence number in Base64 can be retrieved from <code>/sequences/base64</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetSequenceInBase64() throws Exception {
        // given
        expectedResult = "MTIzNDU";

        // when
        supplier = api::nextSequenceInBase64;

        // then
        requestAndVerify("/sequences/base64");
    }

    /**
     * Ensures that a sequence number as HashId can be retrieved from <code>/sequences/hashid</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetSequenceAsHashId() throws Exception {
        // given
        expectedResult = "4mR";

        // when
        supplier = api::nextSequenceAsHashId;

        // then
        requestAndVerify("/sequences/hashid");
    }

}
