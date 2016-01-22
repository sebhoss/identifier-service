package com.github.sebhoss.identifier.service;

import com.github.sebhoss.identifier.usecases.Identifiers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Base64;
import java.util.UUID;
import java.util.function.LongSupplier;

import static java.lang.String.valueOf;
import static java.lang.System.currentTimeMillis;
import static java.util.UUID.randomUUID;

@Service
class SuppliedIdentifiers implements Identifiers {

    private final LongSupplier longSupplier;

    @Autowired
    SuppliedIdentifiers(final LongSupplier longSupplier) {
        this.longSupplier = longSupplier;
    }

    @Override
    public String nextSequence() {
        return valueOf(longSupplier.getAsLong());
    }

    @Override
    public String nextSequenceInBase36() {
        return convertDecToBase36(valueOf(longSupplier.getAsLong()));
    }

    @Override
    public String nextSequenceInBase64() {
        return convertStringToBase64(valueOf(longSupplier.getAsLong()));
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
