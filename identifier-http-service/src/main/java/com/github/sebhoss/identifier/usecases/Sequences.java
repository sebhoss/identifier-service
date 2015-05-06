/*
 * This file is part of identifier-service. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of identifier-service,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package com.github.sebhoss.identifier.usecases;

import com.codahale.metrics.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.github.sebhoss.identifier.usecases.HttpApi.SEQUENCE;
import static com.github.sebhoss.identifier.usecases.HttpApi.SEQUENCE_BASE36;
import static com.github.sebhoss.identifier.usecases.HttpApi.SEQUENCE_BASE62;
import static com.github.sebhoss.identifier.usecases.HttpApi.SEQUENCE_BASE64;
import static com.github.sebhoss.identifier.usecases.HttpApi.SEQUENCE_HASHID;
import static com.github.sebhoss.identifier.usecases.Multiplier.multiple;
import static com.github.sebhoss.identifier.usecases.RequestParameters.DEFAULT_QUANTITY;
import static com.github.sebhoss.identifier.usecases.RequestParameters.QUANTITY;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Sequence based identifiers can be retrieved over HTTP as 'text/plain'.
 */
@RestController
@RequestMapping(produces = TEXT_PLAIN_VALUE, method = GET)
public class Sequences {

    private final API api;

    @Autowired
    Sequences(final API api) {
        this.api = api;
    }

    /**
     * @param quantity
     *            The number of sequences to show.
     * @return The next sequence number.
     */
    @Timed
    @RequestMapping(SEQUENCE)
    public String sequence(final @RequestParam(name = QUANTITY, required = false, defaultValue = DEFAULT_QUANTITY) int quantity) {
        return multiple(quantity, api::nextSequence);
    }

    /**
     * @param quantity
     *            The number of sequences to show.
     * @return The next sequence number in Base36.
     */
    @Timed
    @RequestMapping(SEQUENCE_BASE36)
    public String sequenceInBase36(final @RequestParam(name = QUANTITY, required = false, defaultValue = DEFAULT_QUANTITY) int quantity) {
        return multiple(quantity, api::nextSequenceInBase36);
    }

    /**
     * @param quantity
     *            The number of sequences to show.
     * @return The next sequence number in Base62.
     */
    @Timed
    @RequestMapping(SEQUENCE_BASE62)
    public String sequenceInBase62(final @RequestParam(name = QUANTITY, required = false, defaultValue = DEFAULT_QUANTITY) int quantity) {
        return multiple(quantity, api::nextSequenceInBase62);
    }

    /**
     * @param quantity
     *            The number of sequences to show.
     * @return The next sequence number in Base64.
     */
    @Timed
    @RequestMapping(SEQUENCE_BASE64)
    public String sequenceInBase64(final @RequestParam(name = QUANTITY, required = false, defaultValue = DEFAULT_QUANTITY) int quantity) {
        return multiple(quantity, api::nextSequenceInBase64);
    }

    /**
     * @param quantity
     *            The number of sequences to show.
     * @return The next sequence number as HashId.
     */
    @Timed
    @RequestMapping(SEQUENCE_HASHID)
    public String sequenceAsHashId(final @RequestParam(name = QUANTITY, required = false, defaultValue = DEFAULT_QUANTITY) int quantity) {
        return multiple(quantity, api::nextSequenceAsHashId);
    }

    /**
     * The required internal API to generate sequences.
     */
    public interface API {

        /**
         * @return The next sequence number.
         */
        String nextSequence();

        /**
         * @return The next sequence number in Base36.
         */
        String nextSequenceInBase36();

        /**
         * @return The next sequence number in Base62.
         */
        String nextSequenceInBase62();

        /**
         * @return The next sequence number in Base64.
         */
        String nextSequenceInBase64();

        /**
         * @return The next sequence number as a HashId.
         */
        String nextSequenceAsHashId();

    }

}
