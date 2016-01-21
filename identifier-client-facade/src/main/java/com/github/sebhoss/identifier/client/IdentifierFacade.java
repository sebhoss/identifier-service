package com.github.sebhoss.identifier.client;

/**
 * Facade for the ID HTTP service. Can be used by clients who don't want to think about HTTP and/or where the remote is located
 */
public interface IdentifierFacade {

    String getNextSequence();
    String getNextSequenceInBase36();
    String getNextSequenceInBase64();

    String getNextUuid();
    String getNextUuidInBase36();
    String getNextUuidInBase64();

    String getNextTimestamp();
    String getNextTimestampInBase36();
    String getNextTimestampInBase64();

}
