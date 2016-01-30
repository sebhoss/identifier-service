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
        requestAndVerify("/uuid");
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
