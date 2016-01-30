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
package com.github.sebhoss.identifier.service;

import static java.lang.Long.valueOf;
import static org.mockito.BDDMockito.given;

import java.util.Base64;
import java.util.function.LongSupplier;

import org.hashids.Hashids;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for SuppliedIdentifiers.
 */
@SuppressWarnings({ "boxing", "nls" })
public class SuppliedIdentifiersTest {

    private SuppliedIdentifiers identifiers;
    private LongSupplier        longSupplier;

    /**
     * test setup
     */
    @Before
    public void setUp() {
        longSupplier = Mockito.mock(LongSupplier.class);

        identifiers = new SuppliedIdentifiers(longSupplier, Base64.getEncoder(), new Hashids());
    }

    /**
     * Ensures that the next sequence will be returned correctly.
     */
    @Test
    public void shouldGetNextSequence() {
        given(longSupplier.getAsLong()).willReturn(valueOf(12345));

        final String string = identifiers.nextSequence();

        Assert.assertEquals("12345", string);
    }

    /**
     * Ensures that the next sequence will be returned correctly in Base36.
     */
    @Test
    public void shouldGetNextSequenceInBase36() {
        given(longSupplier.getAsLong()).willReturn(valueOf(12345));

        final String string = identifiers.nextSequenceInBase36();

        Assert.assertEquals("9ix", string);
    }

    /**
     * Ensures that the next sequence will be returned correctly in Base62.
     */
    @Test
    public void shouldGetNextSequenceInBase62() {
        given(longSupplier.getAsLong()).willReturn(valueOf(12345));

        final String string = identifiers.nextSequenceInBase62();

        Assert.assertEquals("dnh", string);
    }

    /**
     * Ensures that the next sequence will be returned correctly in Base64.
     */
    @Test
    public void shouldGetNextSequenceInBase64() {
        given(longSupplier.getAsLong()).willReturn(valueOf(12345));

        final String string = identifiers.nextSequenceInBase64();

        Assert.assertEquals("MTIzNDU", string);
    }

    /**
     * Ensures that the next sequence will be returned correctly as HashId.
     */
    @Test
    public void shouldGetNextSequenceAsHashId() {
        given(longSupplier.getAsLong()).willReturn(valueOf(12345));

        final String string = identifiers.nextSequenceAsHashId();

        Assert.assertEquals("j0gW", string);
    }

    /**
     * Ensures that the next timestamp will be returned correctly.
     */
    @Test
    public void shouldGetNextTimestamp() {
        final String string = identifiers.nextTimestamp();

        Assert.assertNotNull(string);
    }

    /**
     * Ensures that the next timestamp will be returned correctly in Base36.
     */
    @Test
    public void shouldGetNextTimestampInBase36() {
        final String string = identifiers.nextTimestampInBase36();

        Assert.assertNotNull(string);
    }

    /**
     * Ensures that the next timestamp will be returned correctly in Base62.
     */
    @Test
    public void shouldGetNextTimestampInBase62() {
        final String string = identifiers.nextTimestampInBase62();

        Assert.assertNotNull(string);
    }

    /**
     * Ensures that the next timestamp will be returned correctly in Base64.
     */
    @Test
    public void shouldGetNextTimestampInBase64() {
        final String string = identifiers.nextTimestampInBase64();

        Assert.assertNotNull(string);
    }

    /**
     * Ensures that the next timestamp will be returned correctly as HashId.
     */
    @Test
    public void shouldGetNextTimestampAsHashId() {
        final String string = identifiers.nextTimestampAsHashId();

        Assert.assertNotNull(string);
    }

    /**
     * Ensures that the next UUID will be returned correctly.
     */
    @Test
    public void shouldGetNextUuid() {
        final String string = identifiers.nextUuid();

        Assert.assertNotNull(string);
    }

    /**
     * Ensures that the next UUID will be returned correctly in Base36.
     */
    @Test
    public void shouldGetNextUuidInBase36() {
        final String string = identifiers.nextUuidInBase36();

        Assert.assertNotNull(string);
    }

    /**
     * Ensures that the next UUID will be returned correctly in Base62.
     */
    @Test
    public void shouldGetNextUuidInBase62() {
        final String string = identifiers.nextUuidInBase62();

        Assert.assertNotNull(string);
    }

    /**
     * Ensures that the next UUID will be returned correctly in Base64.
     */
    @Test
    public void shouldGetNextUuidInBase64() {
        final String string = identifiers.nextUuidInBase64();

        Assert.assertNotNull(string);
    }

    /**
     * Ensures that the next UUID will be returned correctly as HashId.
     */
    @Test
    public void shouldGetNextUuidAsHashId() {
        final String string = identifiers.nextUuidAsHashId();

        Assert.assertNotNull(string);
    }

}
