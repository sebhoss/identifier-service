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
package com.github.sebhoss.identifier.service;

import java.math.BigInteger;

/**
 *
 *
 */
public class Base62 {

    @SuppressWarnings("nls")
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private static final int        BASE     = ALPHABET.length();
    private static final BigInteger BIG_BASE = BigInteger.valueOf(62);

    private Base62() {
    }

    /**
     * @param i
     *            input
     * @return Base62 encoded output
     */
    public static String fromBase10(final long i) {
        final StringBuilder sb = new StringBuilder(""); //$NON-NLS-1$
        long current = i;
        while (current > 0) {
            current = fromBase10(current, sb);
        }
        return sb.reverse().toString();
    }

    private static long fromBase10(final long i, final StringBuilder sb) {
        final int rem = (int) (i % BASE);
        sb.append(ALPHABET.charAt(rem));
        return i / BASE;
    }

    /**
     * Encodes a number using Base62 encoding.
     *
     * @param number
     *            a positive integer
     * @return a Base62 string
     * @throws IllegalArgumentException
     *             if <code>number</code> is a negative integer
     */
    public static String encode(final BigInteger number) {
        final StringBuilder result = new StringBuilder();
        BigInteger current = number;
        while (current.compareTo(BigInteger.ZERO) == 1) { // number > 0
            final BigInteger[] divmod = current.divideAndRemainder(BIG_BASE);
            current = divmod[0];
            final int digit = divmod[1].intValue();
            result.insert(0, ALPHABET.charAt(digit));
        }
        return result.length() == 0 ? ALPHABET.substring(0, 1) : result.toString();
    }

}
