/*
 * This file is part of identifier-service. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of identifier-service,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package com.github.sebhoss.identifier.service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.function.LongSupplier;

import com.codahale.metrics.annotation.Timed;

import org.springframework.stereotype.Repository;

@Repository
class AtomicLongSupplier implements LongSupplier {

    private static final AtomicLong SEQUENCE = new AtomicLong(0L);

    @Timed
    @Override
    public long getAsLong() {
        return SEQUENCE.getAndIncrement();
    }

}
