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

import com.codahale.metrics.annotation.Timed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Sequence based identifiers can be retrieved over HTTP as 'text/plain'.
 */
@Controller
@RequestMapping(produces = "text/plain", method = RequestMethod.GET)
public class Sequences {

    private final API api;

    @Autowired
    Sequences(final API api) {
        this.api = api;
    }

    /**
     * @return The next sequence number.
     */
    @Timed
    @ResponseBody
    @RequestMapping(HttpApi.SEQUENCE)
    public String sequence() {
        return api.nextSequence();
    }

    /**
     * @return The next sequence number in Base36.
     */
    @Timed
    @ResponseBody
    @RequestMapping(HttpApi.SEQUENCE_BASE36)
    public String sequenceInBase36() {
        return api.nextSequenceInBase36();
    }

    /**
     * @return The next sequence number in Base62.
     */
    @Timed
    @ResponseBody
    @RequestMapping(HttpApi.SEQUENCE_BASE62)
    public String sequenceInBase62() {
        return api.nextSequenceInBase62();
    }

    /**
     * @return The next sequence number in Base64.
     */
    @Timed
    @ResponseBody
    @RequestMapping(HttpApi.SEQUENCE_BASE64)
    public String sequenceInBase64() {
        return api.nextSequenceInBase64();
    }

    /**
     * @return The next sequence number in Base85.
     */
    @Timed
    @ResponseBody
    @RequestMapping(HttpApi.SEQUENCE_BASE85)
    public String sequenceInBase85() {
        return api.nextSequenceInBase85();
    }

    /**
     * @return The next sequence number as HashId.
     */
    @Timed
    @ResponseBody
    @RequestMapping(HttpApi.SEQUENCE_HASHID)
    public String sequenceAsHashId() {
        return api.nextSequenceAsHashId();
    }

    /**
     * The required internal API to generate sequences.
     */
    public static interface API {

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
         * @return The next sequence number in Base85.
         */
        String nextSequenceInBase85();

        /**
         * @return The next sequence number as a HashId.
         */
        String nextSequenceAsHashId();

    }

}
