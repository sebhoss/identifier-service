/*
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 *
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * For more information, please refer to <http://unlicense.org>
 */
package com.github.sebhoss.identifier.usecases;

import static com.github.sebhoss.identifier.usecases.Multiplier.multiple;

import com.codahale.metrics.annotation.Timed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Timestamp based identifiers can be retrieved over HTTP as 'text/plain'.
 */
@RestController
@RequestMapping(produces = "text/plain", method = RequestMethod.GET)
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
    @RequestMapping(HttpApi.TIMESTAMP)
    public String timestamp(final @RequestParam(name = "quantity", required = false, defaultValue = "1") int quantity) {
        return multiple(quantity, api::nextTimestamp);
    }

    /**
     * @param quantity
     *            The number of timestamps to show.
     * @return The current timestamp in Base36.
     */
    @Timed
    @RequestMapping(HttpApi.TIMESTAMP_BASE36)
    public String timestampInBase36(
            final @RequestParam(name = "quantity", required = false, defaultValue = "1") int quantity) {
        return multiple(quantity, api::nextTimestampInBase36);
    }

    /**
     * @param quantity
     *            The number of timestamps to show.
     * @return The current timestamp in Base62.
     */
    @Timed
    @RequestMapping(HttpApi.TIMESTAMP_BASE62)
    public String timestampInBase62(
            final @RequestParam(name = "quantity", required = false, defaultValue = "1") int quantity) {
        return multiple(quantity, api::nextTimestampInBase62);
    }

    /**
     * @param quantity
     *            The number of timestamps to show.
     * @return The current timestamp in Base64.
     */
    @Timed
    @RequestMapping(HttpApi.TIMESTAMP_BASE64)
    public String timestampInBase64(
            final @RequestParam(name = "quantity", required = false, defaultValue = "1") int quantity) {
        return multiple(quantity, api::nextTimestampInBase64);
    }

    /**
     * @param quantity
     *            The number of timestamps to show.
     * @return The current timestamp as HashId.
     */
    @Timed
    @RequestMapping(HttpApi.TIMESTAMP_HASHID)
    public String timestampAsHashId(
            final @RequestParam(name = "quantity", required = false, defaultValue = "1") int quantity) {
        return multiple(quantity, api::nextTimestampAsHashId);
    }

    /**
     * The required internal API to generate timestamps.
     */
    public static interface API {

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
