package com.github.sebhoss.identifier.usecases;

import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 *
 */
final class Multiplier {

    public static final String multiple(final int quantity, final Supplier<String> supplier) {
        return IntStream.range(0, quantity)
                .mapToObj(i -> supplier.get())
                .collect(Collectors.joining("\n")); //$NON-NLS-1$
    }

    private Multiplier() {
        // utility class
    }
}
