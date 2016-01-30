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
