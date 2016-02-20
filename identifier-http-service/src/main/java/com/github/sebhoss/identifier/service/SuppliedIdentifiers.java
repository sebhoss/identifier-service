/*
 * This file is part of identifier-service. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of identifier-service,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package com.github.sebhoss.identifier.service;

import static java.lang.String.valueOf;
import static java.lang.System.currentTimeMillis;
import static java.util.UUID.randomUUID;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Base64.Encoder;
import java.util.UUID;
import java.util.function.LongSupplier;

import com.codahale.metrics.annotation.Timed;
import com.github.sebhoss.identifier.usecases.SlackCommands;

import org.hashids.Hashids;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class SuppliedIdentifiers implements SlackCommands.API {

    private final LongSupplier longSupplier;
    private final Encoder      encoder;
    private final Hashids      hashids;

    @Autowired
    SuppliedIdentifiers(
            final LongSupplier longSupplier,
            final Encoder encoder,
            final Hashids hashids) {
        this.longSupplier = longSupplier;
        this.encoder = encoder;
        this.hashids = hashids;
    }

    @Timed
    @Override
    public String nextSequence() {
        return valueOf(longSupplier.getAsLong());
    }

    @Timed
    @Override
    public String nextSequenceInBase36() {
        return convertDecToBase36(valueOf(longSupplier.getAsLong()));
    }

    @Override
    public String nextSequenceInBase62() {
        return Base62.fromBase10(longSupplier.getAsLong());
    }

    @Timed
    @Override
    public String nextSequenceInBase64() {
        return convertStringToBase64(valueOf(longSupplier.getAsLong()));
    }

    @Override
    public String nextSequenceAsHashId() {
        return hashids.encode(longSupplier.getAsLong());
    }

    @Timed
    @Override
    public String nextTimestamp() {
        return valueOf(currentTimeMillis());
    }

    @Timed
    @Override
    public String nextTimestampInBase36() {
        return convertDecToBase36(valueOf(currentTimeMillis()));
    }

    @Override
    public String nextTimestampInBase62() {
        return Base62.fromBase10(currentTimeMillis());
    }

    @Timed
    @Override
    public String nextTimestampInBase64() {
        return convertStringToBase64(valueOf(currentTimeMillis()));
    }

    @Override
    public String nextTimestampAsHashId() {
        return hashids.encode(currentTimeMillis());
    }

    @Timed
    @Override
    public String nextUuid() {
        return randomUUID().toString();
    }

    @Timed
    @Override
    public String nextUuidInBase36() {
        return convertUuidToBase36(randomUUID());
    }

    @Override
    public String nextUuidInBase62() {
        return Base62.encode(new BigInteger(convertUuidToString(randomUUID()), 16));
    }

    @Timed
    @Override
    public String nextUuidInBase64() {
        return convertUuidToBase64(randomUUID());
    }

    @Override
    public String nextUuidAsHashId() {
        return hashids.encodeHex(convertUuidToString(randomUUID()));
    }

    private static String convertUuidToBase36(final UUID uuid) {
        return convertHexToBase36(convertUuidToString(uuid));
    }

    private String convertUuidToBase64(final UUID uuid) {
        final ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        return removePadding(encoder.encodeToString(bb.array()));
    }

    private static String convertUuidToString(final UUID uuid) {
        return uuid.toString().replace("-", ""); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private static String convertDecToBase36(final String dec) {
        return convertFromBaseToBase(dec, 10, 36);
    }

    private static String convertHexToBase36(final String hex) {
        return convertFromBaseToBase(hex, 16, 36);
    }

    private static String convertFromBaseToBase(final String value, final int from, final int to) {
        return new BigInteger(value, from).toString(to);
    }

    private String convertStringToBase64(final String value) {
        return removePadding(encoder.encodeToString(getBytes(value)));
    }

    private static byte[] getBytes(final String value) {
        return value.getBytes(StandardCharsets.US_ASCII);
    }

    private static String removePadding(final String string) {
        if (string.endsWith("==")) { //$NON-NLS-1$
            return string.substring(0, string.length() - 2);
        }
        if (string.endsWith("=")) { //$NON-NLS-1$
            return string.substring(0, string.length() - 1);
        }
        return string;
    }

}
