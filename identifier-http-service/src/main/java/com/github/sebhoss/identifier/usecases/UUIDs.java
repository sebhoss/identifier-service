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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * UUID based identifiers can be retrieved over HTTP as 'text/plain'.
 */
@Controller
@RequestMapping(produces = "text/plain", method = RequestMethod.GET)
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
    @ResponseBody
    @RequestMapping(HttpApi.UUID)
    public String uuid(final @RequestParam(name = "quantity", required = false, defaultValue = "1") int quantity) {
        return multiple(quantity, api::nextUuid);
    }

    /**
     * @param quantity
     *            The number of UUIDs to show.
     * @return The next UUID in Base36.
     */
    @Timed
    @ResponseBody
    @RequestMapping(HttpApi.UUID_BASE36)
    public String uuidInBase36(
            final @RequestParam(name = "quantity", required = false, defaultValue = "1") int quantity) {
        return multiple(quantity, api::nextUuidInBase36);
    }

    /**
     * @param quantity
     *            The number of UUIDs to show.
     * @return The next UUID in Base62.
     */
    @Timed
    @ResponseBody
    @RequestMapping(HttpApi.UUID_BASE62)
    public String uuidInBase62(
            final @RequestParam(name = "quantity", required = false, defaultValue = "1") int quantity) {
        return multiple(quantity, api::nextUuidInBase62);
    }

    /**
     * @param quantity
     *            The number of UUIDs to show.
     * @return The next UUID in Base64.
     */
    @Timed
    @ResponseBody
    @RequestMapping(HttpApi.UUID_BASE64)
    public String uuidInBase64(
            final @RequestParam(name = "quantity", required = false, defaultValue = "1") int quantity) {
        return multiple(quantity, api::nextUuidInBase64);
    }

    /**
     * @param quantity
     *            The number of UUIDs to show.
     * @return The next UUID as HashId.
     */
    @Timed
    @ResponseBody
    @RequestMapping(HttpApi.UUID_HASHID)
    public String uuidAsHashId(
            final @RequestParam(name = "quantity", required = false, defaultValue = "1") int quantity) {
        return multiple(quantity, api::nextUuidAsHashId);
    }

    /**
     * The required internal API to generate UUIDs.
     */
    public static interface API {

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
