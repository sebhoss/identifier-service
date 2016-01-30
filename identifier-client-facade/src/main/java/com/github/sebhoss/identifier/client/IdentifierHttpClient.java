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
package com.github.sebhoss.identifier.client;

/**
 * Facade for the ID HTTP service. Can be used by clients who don't want to think about HTTP and/or where the remote is
 * located
 */
public interface IdentifierHttpClient {

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
