/*
 * This file is part of identifier-service. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of identifier-service,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package com.github.sebhoss.identifier.client;

/**
 * Client facade to interact with an ID service. Can be used by clients who don't want to think about HTTP and/or where
 * the remote is located. An additional non-HTTP implementation is provided as well in order to allow clients to easily
 * switch between locally and remotely generated IDs.
 */
public interface IdentifierClient {

    /**
     * @return The next sequence number.
     */
    String getNextSequence();

    /**
     * @return The next sequence number in Base36.
     */
    String getNextSequenceInBase36();

    /**
     * @return The next sequence number in Base62.
     */
    String getNextSequenceInBase62();

    /**
     * @return The next sequence number in Base64.
     */
    String getNextSequenceInBase64();

    /**
     * @return The next sequence number as HashId.
     */
    String getNextSequenceAsHashId();

    /**
     * @return The next timestamp.
     */
    String getNextTimestamp();

    /**
     * @return The next timestamp in Base36.
     */
    String getNextTimestampInBase36();

    /**
     * @return The next timestamp in Base62.
     */
    String getNextTimestampInBase62();

    /**
     * @return The next timestamp in Base64.
     */
    String getNextTimestampInBase64();

    /**
     * @return The next timestamp as HashId.
     */
    String getNextTimestampAsHashId();

    /**
     * @return The next UUID.
     */
    String getNextUuid();

    /**
     * @return The next UUID in Base36.
     */
    String getNextUuidInBase36();

    /**
     * @return The next UUID in Base62.
     */
    String getNextUuidInBase62();

    /**
     * @return The next UUID in Base64.
     */
    String getNextUuidInBase64();

    /**
     * @return The next UUID as HashId.
     */
    String getNextUuidAsHashId();

}
