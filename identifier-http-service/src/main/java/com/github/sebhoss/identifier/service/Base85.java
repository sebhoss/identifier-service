package com.github.sebhoss.identifier.service;

/**
 * Author: Bubelich Mykola Date: 2015-06-01 Implementation of jBaseZ85 data encoding/decoding
 * https://github.com/thesimj/jBaseZ85
 * 
 * @author Bubelich Mykola (bubelich.com)
 */
public class Base85 {

    @SuppressWarnings("nls")
    private final static char[] _ALPHA = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ.-:+=^!/*?&<>()[]{}@%$#"
            .toCharArray();

    /**
     * Encode the Byte array into jBaseZ85 format.
     *
     * @param input
     *            byte[] Array of byte to encode.
     * @return String The encoded String
     * @throws RuntimeException
     *             poof
     */
    public static String encode(final byte[] input) throws RuntimeException {
        // check input len > 0 or null//
        if (input == null || input.length == 0) {
            throw new IllegalArgumentException("Input is wrong"); //$NON-NLS-1$
        }

        int length = input.length;
        int index = 0;
        byte[] buff = new byte[4];

        // Use mutable StringBuilder for fast string append //
        final StringBuilder sb = new StringBuilder(input.length * 5 / 4 + 1);

        while (length >= 4) {
            // copy input to buff //
            buff[3] = input[index++];
            buff[2] = input[index++];
            buff[1] = input[index++];
            buff[0] = input[index++];

            // Append result string to StringBuilder
            sb.append(encodeQuarter(buff));

            length -= 4;
        }

        // Padding zone //
        if (length > 0) {
            buff = new byte[length];

            for (int i = length - 1; i >= 0; i--) {
                buff[i] = input[index++];
            }

            // Append result string to StringBuilder
            sb.append(encodePadding(buff));
        }

        // Return whole string //
        return sb.toString();
    }

    private static char[] encodeQuarter(final byte[] data) {
        final long value = data[0] & 0x00000000000000FFL |
                (data[1] & 0x00000000000000FFL) << 8 |
                (data[2] & 0x00000000000000FFL) << 16 |
                (data[3] & 0x00000000000000FFL) << 24;

        final char[] out = new char[5];

        out[0] = _ALPHA[(int) (value / 0x31C84B1L % 85)];
        out[1] = _ALPHA[(int) (value / 0x95EEDL % 85)];
        out[2] = _ALPHA[(int) (value / 0x1C39L % 85)];
        out[3] = _ALPHA[(int) (value / 0x55L % 85)];
        out[4] = _ALPHA[(int) (value % 85)];

        return out;
    }

    /**
     * Encode padding scheme
     *
     * @param data
     *            byte[] Array of length = 4 of data
     * @return char[] Encoded padding
     */
    private static char[] encodePadding(final byte[] data) {
        long value = 0;
        final int length = data.length * 5 / 4 + 1;
        final char[] out = new char[length];

        switch (data.length) {
            case 3:
                value |= (data[2] & 0x00000000000000FFL) << 16;
                break;
            case 2:
                value |= (data[1] & 0x00000000000000FFL) << 8;
                break;
            default:
                break;
        }

        value |= data[0] & 0x00000000000000FFL;

        switch (data.length) {
            case 3:
                out[3] = _ALPHA[(int) (value / 0x95EEDL % 85)];
                break;
            case 2:
                out[2] = _ALPHA[(int) (value / 0x1C39L % 85)];
                break;
            default:
                break;
        }

        out[1] = _ALPHA[(int) (value / 0x55L % 85)];
        out[0] = _ALPHA[(int) (value % 85)];

        return out;
    }

}
