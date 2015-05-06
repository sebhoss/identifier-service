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
 * Unit test for {@link UUIDs}.
 */
@SuppressWarnings("nls")
public class UUIDsTest extends AbstractMockMvcTest<UUIDs, UUIDs.API> {

    /**
     * Provides the superclass with required infrastructure.
     */
    public UUIDsTest() {
        super(UUIDs::new, UUIDs.API.class);
    }

    /**
     * Ensures that an UUID can be retrieved from <code>/uuids/uuid</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetUuid() throws Exception {
        // given
        expectedResult = "0930b880-c13a-11e5-a837-0800200c9a66";

        // when
        supplier = api::nextUuid;

        // then
        requestAndVerify("/uuids/uuid");
    }

    /**
     * Ensures that an UUID in Base36 can be retrieved from <code>/uuids/base36</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetUuidInBase36() throws Exception {
        // given
        expectedResult = "9xyplmzaulvyb16rmz32qg1rw=";

        // when
        supplier = api::nextUuidInBase36;

        // then
        requestAndVerify("/uuids/base36");
    }

    /**
     * Ensures that an UUID in Base36 can be retrieved from <code>/uuids/base64</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetUuidInBase64() throws Exception {
        // given
        expectedResult = "Y2UyNGI3OTM2OTFlNDViZjhmN2RhOTU3ZWZjNzNlNTU=";

        // when
        supplier = api::nextUuidInBase64;

        // then
        requestAndVerify("/uuids/base64");
    }

}
