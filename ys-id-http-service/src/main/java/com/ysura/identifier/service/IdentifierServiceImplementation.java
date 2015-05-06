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

import static java.lang.String.valueOf;
import static java.lang.System.currentTimeMillis;
import static java.util.UUID.randomUUID;

import java.math.BigInteger;
import java.util.Base64;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysura.identifier.persistence.IdentifierRepository;

@Service
class IdentifierServiceImplementation implements IdentifierService {

    private final IdentifierRepository identifierRepository;

    @Autowired
    IdentifierServiceImplementation(final IdentifierRepository identifierRepository) {
        this.identifierRepository = identifierRepository;
    }

    @Override
    public String nextSequence() {
        return valueOf(identifierRepository.nextSequenceValue());
    }

    @Override
    public String nextSequenceInBase36() {
        return convertDecToBase36(valueOf(identifierRepository.nextSequenceValue()));
    }

    @Override
    public String nextSequenceInBase64() {
        return convertStringToBase64(valueOf(identifierRepository.nextSequenceValue()));
    }

    @Override
    public String nextUuid() {
        return randomUUID().toString();
    }

    @Override
    public String nextUuidInBase36() {
        return convertUUIDToBase36(randomUUID());
    }

    @Override
    public String nextUuidInBase64() {
        return convertUUIDToBase64(randomUUID());
    }

    @Override
    public String nextTimestamp() {
        return valueOf(currentTimeMillis());
    }

    @Override
    public String nextTimestampInBase36() {
        return convertDecToBase36(valueOf(currentTimeMillis()));
    }

    @Override
    public String nextTimestampInBase64() {
        return convertStringToBase64(valueOf(currentTimeMillis()));
    }

    private String convertUUIDToBase36(final UUID uuid) {
        return convertHexToBase36(convertUuidToString(uuid));
    }

    private String convertUUIDToBase64(final UUID uuid) {
        return convertStringToBase64(convertUuidToString(uuid));
    }

    private String convertUuidToString(final UUID uuid) {
        return uuid.toString().replace("-", "");
    }

    private String convertDecToBase36(final String dec) {
        return convertFromBaseToBase(dec, 10, 36);
    }

    private String convertHexToBase36(final String hex) {
        return convertFromBaseToBase(hex, 16, 36);
    }

    private String convertFromBaseToBase(final String value, final int from, final int to) {
        return new BigInteger(value, from).toString(to);
    }

    private String convertStringToBase64(final String value) {
        return Base64.getEncoder().encodeToString(value.getBytes());
    }

}
