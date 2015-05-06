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
 * Unit test for {@link Timestamps}.
 */
@SuppressWarnings("nls")
public class TimestampsTest extends AbstractMockMvcTest<Timestamps, Timestamps.API> {

    /**
     * Provides the superclass with required infrastructure.
     */
    public TimestampsTest() {
        super(Timestamps::new, Timestamps.API.class);
    }

    /**
     * Ensures that the current timestamp can be retrieved from <code>/timestamps/timestamp</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetTimestamp() throws Exception {
        // given
        expectedResult = "1430921821283";

        // when
        supplier = api::nextTimestamp;

        // then
        requestAndVerify("/timestamps/timestamp");
    }

    /**
     * Ensures that the current timestamp in Base36 can be retrieved from <code>/timestamps/base36</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetTimestampInBase36() throws Exception {
        // given
        expectedResult = "i8zoo1fk";

        // when
        supplier = api::nextTimestampInBase36;

        // then
        requestAndVerify("/timestamps/base36");
    }

    /**
     * Ensures that the current timestamp in Base62 can be retrieved from <code>/timestamps/base62</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetTimestampInBase62() throws Exception {
        // given
        expectedResult = "zLsmkes";

        // when
        supplier = api::nextTimestampInBase62;

        // then
        requestAndVerify("/timestamps/base62");
    }

    /**
     * Ensures that the current timestamp in Base64 can be retrieved from <code>/timestamps/base64</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetTimestampInBase64() throws Exception {
        // given
        expectedResult = "MTQzMDkyMzY2OTEyNw";

        // when
        supplier = api::nextTimestampInBase64;

        // then
        requestAndVerify("/timestamps/base64");
    }

    /**
     * Ensures that the current timestamp as HashId can be retrieved from <code>/timestamps/hashid</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetTimestampAsHashId() throws Exception {
        // given
        expectedResult = "53lk23XP6";

        // when
        supplier = api::nextTimestampAsHashId;

        // then
        requestAndVerify("/timestamps/hashid");
    }

}
