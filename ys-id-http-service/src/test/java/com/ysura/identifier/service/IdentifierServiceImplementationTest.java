/*
 * ysura GmbH ("COMPANY") CONFIDENTIAL
 * Unpublished Copyright (c) 2012-2015 ysura GmbH, All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains the property of COMPANY. The intellectual and technical concepts contained
 * herein are proprietary to COMPANY and may be covered by U.S. and Foreign Patents, patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material is strictly forbidden unless prior written permission is obtained
 * from COMPANY.  Access to the source code contained herein is hereby forbidden to anyone except current COMPANY employees, managers or contractors who have executed
 * Confidentiality and Non-disclosure agreements explicitly covering such access.
 *
 * The copyright notice above does not evidence any actual or intended publication or disclosure  of  this source code, which includes
 * information that is confidential and/or proprietary, and is a trade secret, of COMPANY. ANY REPRODUCTION, MODIFICATION, DISTRIBUTION, PUBLIC PERFORMANCE,
 * OR PUBLIC DISPLAY OF OR THROUGH USE  OF THIS SOURCE CODE WITHOUT THE EXPRESS WRITTEN CONSENT OF COMPANY IS STRICTLY PROHIBITED, AND IN VIOLATION OF APPLICABLE
 * LAWS AND INTERNATIONAL TREATIES. THE RECEIPT OR POSSESSION OF THIS SOURCE CODE AND/OR RELATED INFORMATION DOES NOT CONVEY OR IMPLY ANY RIGHTS
 * TO REPRODUCE, DISCLOSE OR DISTRIBUTE ITS CONTENTS, OR TO MANUFACTURE, USE, OR SELL ANYTHING THAT IT MAY DESCRIBE, IN WHOLE OR IN PART.
 */
package com.ysura.identifier.service;

import static java.lang.Long.valueOf;
import static org.mockito.BDDMockito.given;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.ysura.identifier.persistence.IdentifierRepository;

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
