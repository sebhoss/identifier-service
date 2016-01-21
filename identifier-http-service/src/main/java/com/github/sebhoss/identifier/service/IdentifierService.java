package com.github.sebhoss.identifier.service;

/**
 * Returns (random) identifiers.
 */
public interface IdentifierService {

    String nextSequence();
    String nextSequenceInBase36();
    String nextSequenceInBase64();

    String nextUuid();
    String nextUuidInBase36();
    String nextUuidInBase64();

    String nextTimestamp();
    String nextTimestampInBase36();
    String nextTimestampInBase64();

}
