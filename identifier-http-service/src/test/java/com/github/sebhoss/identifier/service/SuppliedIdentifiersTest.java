package com.github.sebhoss.identifier.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.function.LongSupplier;

import static java.lang.Long.valueOf;
import static org.mockito.BDDMockito.given;

public class SuppliedIdentifiersTest {

    private SuppliedIdentifiers identifiers;
    private LongSupplier longSupplier;

    @Before
    public void setUp() {
        longSupplier = Mockito.mock(LongSupplier.class);

        identifiers = new SuppliedIdentifiers(longSupplier);
    }

    @Test
    public void shouldGetNextSequence() {
        given(longSupplier.getAsLong()).willReturn(valueOf(12345));

        String string = identifiers.nextSequence();

        Assert.assertEquals("12345", string);
    }

    @Test
    public void shouldGetNextSequenceInBase36() {
        given(longSupplier.getAsLong()).willReturn(valueOf(12345));

        String string = identifiers.nextSequenceInBase36();

        Assert.assertEquals("9ix", string);
    }

    @Test
    public void shouldGetNextSequenceInBase64() {
        given(longSupplier.getAsLong()).willReturn(valueOf(12345));

        String string = identifiers.nextSequenceInBase64();

        Assert.assertEquals("MTIzNDU=", string);
    }

    @Test
    public void shouldGetNextUuid() {
        String string = identifiers.nextUuid();

        Assert.assertNotNull(string);
    }

    @Test
    public void shouldGetNextUuidInBase36() {
        String string = identifiers.nextUuidInBase36();

        Assert.assertNotNull(string);
    }

    @Test
    public void shouldGetNextUuidInBase64() {
        String string = identifiers.nextUuidInBase64();

        Assert.assertNotNull(string);
    }

    @Test
    public void shouldGetNextTimestamp() {
        String string = identifiers.nextTimestamp();

        Assert.assertNotNull(string);
    }

    @Test
    public void shouldGetNextTimestampInBase36() {
        String string = identifiers.nextTimestampInBase36();

        Assert.assertNotNull(string);
    }

    @Test
    public void shouldGetNextTimestampInBase64() {
        String string = identifiers.nextTimestampInBase64();

        Assert.assertNotNull(string);
    }

}
