/*
 * This file is part of identifier-service. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of identifier-service,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package com.github.sebhoss.identifier.usecases;

import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *  Utility class that calls a supplier multiple times.
 */
final class Multiplier {

    /**
     * Performs multiple calls to the provided supplier. Each supplied value will be on its own line.
     *
     * @param quantity The number of calls to perform.
     * @param supplier The supplier to call.
     * @return The resulting String of calling the 'supplier' 'quantity'-times.
     */
    public static String multiple(final int quantity, final Supplier<String> supplier) {
        return IntStream.range(0, Math.max(1, quantity))
                .mapToObj(i -> supplier.get())
                .collect(Collectors.joining("\n")); //$NON-NLS-1$
    }

    private Multiplier() {
        // utility class
    }

}
