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
