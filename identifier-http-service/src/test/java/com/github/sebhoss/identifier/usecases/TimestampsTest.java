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
     * Ensures that the current timestamp can be retrieved from <code>/timestamp</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetTimestamp() throws Exception {
        expectedResult = "1430921821283";
        supplier = api::nextTimestamp;

        requestAndVerify("/timestamp");
    }

    /**
     * Ensures that the current timestamp in Base36 can be retrieved from <code>/timestamp/base36</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetTimestampInBase36() throws Exception {
        expectedResult = "i8zoo1fk";
        supplier = api::nextTimestampInBase36;

        requestAndVerify("/timestamp/base36");
    }

    /**
     * Ensures that the current timestamp in Base64 can be retrieved from <code>/timestamp/base64</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetTimestampInBase64() throws Exception {
        expectedResult = "MTQzMDkyMzY2OTEyNw==";
        supplier = api::nextTimestampInBase64;

        requestAndVerify("/timestamp/base64");
    }

}
