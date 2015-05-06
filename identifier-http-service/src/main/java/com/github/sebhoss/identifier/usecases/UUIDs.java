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

import static com.github.sebhoss.identifier.usecases.HttpApi.UUID;
import static com.github.sebhoss.identifier.usecases.HttpApi.UUID_BASE36;
import static com.github.sebhoss.identifier.usecases.HttpApi.UUID_BASE62;
import static com.github.sebhoss.identifier.usecases.HttpApi.UUID_BASE64;
import static com.github.sebhoss.identifier.usecases.HttpApi.UUID_HASHID;
import static com.github.sebhoss.identifier.usecases.Multiplier.multiple;
import static com.github.sebhoss.identifier.usecases.RequestParameters.DEFAULT_QUANTITY;
import static com.github.sebhoss.identifier.usecases.RequestParameters.QUANTITY;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * UUID based identifiers can be retrieved over HTTP as 'text/plain'.
 */
@RestController
@RequestMapping(produces = TEXT_PLAIN_VALUE, method = GET)
public class UUIDs {

    private final API api;

    @Autowired
    UUIDs(final API api) {
        this.api = api;
    }

    /**
     * @param quantity
     *            The number of UUIDs to show.
     * @return The next UUID.
     */
    @Timed
    @RequestMapping(UUID)
    public String uuid(final @RequestParam(name = QUANTITY, required = false, defaultValue = DEFAULT_QUANTITY) int quantity) {
        return multiple(quantity, api::nextUuid);
    }

    /**
     * @param quantity
     *            The number of UUIDs to show.
     * @return The next UUID in Base36.
     */
    @Timed
    @RequestMapping(UUID_BASE36)
    public String uuidInBase36(final @RequestParam(name = QUANTITY, required = false, defaultValue = DEFAULT_QUANTITY) int quantity) {
        return multiple(quantity, api::nextUuidInBase36);
    }

    /**
     * @param quantity
     *            The number of UUIDs to show.
     * @return The next UUID in Base62.
     */
    @Timed
    @RequestMapping(UUID_BASE62)
    public String uuidInBase62(final @RequestParam(name = QUANTITY, required = false, defaultValue = DEFAULT_QUANTITY) int quantity) {
        return multiple(quantity, api::nextUuidInBase62);
    }

    /**
     * @param quantity
     *            The number of UUIDs to show.
     * @return The next UUID in Base64.
     */
    @Timed
    @RequestMapping(UUID_BASE64)
    public String uuidInBase64(final @RequestParam(name = QUANTITY, required = false, defaultValue = DEFAULT_QUANTITY) int quantity) {
        return multiple(quantity, api::nextUuidInBase64);
    }

    /**
     * @param quantity
     *            The number of UUIDs to show.
     * @return The next UUID as HashId.
     */
    @Timed
    @RequestMapping(UUID_HASHID)
    public String uuidAsHashId(final @RequestParam(name = QUANTITY, required = false, defaultValue = DEFAULT_QUANTITY) int quantity) {
        return multiple(quantity, api::nextUuidAsHashId);
    }

    /**
     * The required internal API to generate UUIDs.
     */
    public interface API {

        /**
         * @return The next UUID.
         */
        String nextUuid();

        /**
         * @return The next UUID in Base36.
         */
        String nextUuidInBase36();

        /**
         * @return The next UUID in Base62.
         */
        String nextUuidInBase62();

        /**
         * @return The next UUID in Base64.
         */
        String nextUuidInBase64();

        /**
         * @return The next UUID as a HashId.
         */
        String nextUuidAsHashId();

    }

}
