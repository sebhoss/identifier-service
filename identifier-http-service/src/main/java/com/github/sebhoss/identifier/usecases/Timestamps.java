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

import static com.github.sebhoss.identifier.usecases.HttpApi.TIMESTAMP;
import static com.github.sebhoss.identifier.usecases.HttpApi.TIMESTAMP_BASE36;
import static com.github.sebhoss.identifier.usecases.HttpApi.TIMESTAMP_BASE62;
import static com.github.sebhoss.identifier.usecases.HttpApi.TIMESTAMP_BASE64;
import static com.github.sebhoss.identifier.usecases.HttpApi.TIMESTAMP_HASHID;
import static com.github.sebhoss.identifier.usecases.Multiplier.multiple;
import static com.github.sebhoss.identifier.usecases.RequestParameters.DEFAULT_QUANTITY;
import static com.github.sebhoss.identifier.usecases.RequestParameters.QUANTITY;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Timestamp based identifiers can be retrieved over HTTP as 'text/plain'.
 */
@RestController
@RequestMapping(produces = TEXT_PLAIN_VALUE, method = GET)
public class Timestamps {

    private final API api;

    @Autowired
    Timestamps(final API api) {
        this.api = api;
    }

    /**
     * @param quantity
     *            The number of timestamps to show.
     * @return The current timestamp.
     */
    @Timed
    @RequestMapping(TIMESTAMP)
    public String timestamp(final @RequestParam(name = QUANTITY, required = false, defaultValue = DEFAULT_QUANTITY) int quantity) {
        return multiple(quantity, api::nextTimestamp);
    }

    /**
     * @param quantity
     *            The number of timestamps to show.
     * @return The current timestamp in Base36.
     */
    @Timed
    @RequestMapping(TIMESTAMP_BASE36)
    public String timestampInBase36(final @RequestParam(name = QUANTITY, required = false, defaultValue = DEFAULT_QUANTITY) int quantity) {
        return multiple(quantity, api::nextTimestampInBase36);
    }

    /**
     * @param quantity
     *            The number of timestamps to show.
     * @return The current timestamp in Base62.
     */
    @Timed
    @RequestMapping(TIMESTAMP_BASE62)
    public String timestampInBase62(final @RequestParam(name = QUANTITY, required = false, defaultValue = DEFAULT_QUANTITY) int quantity) {
        return multiple(quantity, api::nextTimestampInBase62);
    }

    /**
     * @param quantity
     *            The number of timestamps to show.
     * @return The current timestamp in Base64.
     */
    @Timed
    @RequestMapping(TIMESTAMP_BASE64)
    public String timestampInBase64(final @RequestParam(name = QUANTITY, required = false, defaultValue = DEFAULT_QUANTITY) int quantity) {
        return multiple(quantity, api::nextTimestampInBase64);
    }

    /**
     * @param quantity
     *            The number of timestamps to show.
     * @return The current timestamp as HashId.
     */
    @Timed
    @RequestMapping(TIMESTAMP_HASHID)
    public String timestampAsHashId(final @RequestParam(name = QUANTITY, required = false, defaultValue = DEFAULT_QUANTITY) int quantity) {
        return multiple(quantity, api::nextTimestampAsHashId);
    }

    /**
     * The required internal API to generate timestamps.
     */
    public interface API {

        /**
         * @return The current timestamp.
         */
        String nextTimestamp();

        /**
         * @return The current timestamp in Base36.
         */
        String nextTimestampInBase36();

        /**
         * @return The current timestamp in Base62.
         */
        String nextTimestampInBase62();

        /**
         * @return The current timestamp in Base64.
         */
        String nextTimestampInBase64();

        /**
         * @return The current timestamp as a HashId.
         */
        String nextTimestampAsHashId();

    }

}
