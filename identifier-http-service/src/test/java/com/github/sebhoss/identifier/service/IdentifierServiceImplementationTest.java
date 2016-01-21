package com.github.sebhoss.identifier.service;

import com.github.sebhoss.identifier.persistence.IdentifierRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static java.lang.Long.valueOf;
import static org.mockito.BDDMockito.given;

public class IdentifierServiceImplementationTest {

    private IdentifierService identifierService;
    private IdentifierRepository identifierRepository;

    @Before
    public void setUp() {
        identifierRepository = Mockito.mock(IdentifierRepository.class);

        identifierService = new IdentifierServiceImplementation(identifierRepository);
    }

    @Test
    public void shouldGetNextSequence() {
        given(identifierRepository.nextSequenceValue()).willReturn(valueOf(12345));

        String string = identifierService.nextSequence();

        Assert.assertEquals("12345", string);
    }

    @Test
    public void shouldGetNextSequenceInBase36() {
        given(identifierRepository.nextSequenceValue()).willReturn(valueOf(12345));

        String string = identifierService.nextSequenceInBase36();

        Assert.assertEquals("9ix", string);
    }

    @Test
    public void shouldGetNextSequenceInBase64() {
        given(identifierRepository.nextSequenceValue()).willReturn(valueOf(12345));

        String string = identifierService.nextSequenceInBase64();

        Assert.assertEquals("MTIzNDU=", string);
    }

    @Test
    public void shouldGetNextUuid() {
        String string = identifierService.nextUuid();

        Assert.assertNotNull(string);
    }

    @Test
    public void shouldGetNextUuidInBase36() {
        String string = identifierService.nextUuidInBase36();

        Assert.assertNotNull(string);
    }

    @Test
    public void shouldGetNextUuidInBase64() {
        String string = identifierService.nextUuidInBase64();

        Assert.assertNotNull(string);
    }

    @Test
    public void shouldGetNextTimestamp() {
        String string = identifierService.nextTimestamp();

        Assert.assertNotNull(string);
    }

    @Test
    public void shouldGetNextTimestampInBase36() {
        String string = identifierService.nextTimestampInBase36();

        Assert.assertNotNull(string);
    }

    @Test
    public void shouldGetNextTimestampInBase64() {
        String string = identifierService.nextTimestampInBase64();

        Assert.assertNotNull(string);
    }

}
