/*
 * This file is part of identifier-service. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of identifier-service,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package com.github.sebhoss.identifier.service;

import org.hashids.Hashids;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Base64;
import java.util.Base64.Encoder;

/**
 * Configuration for the classes inside the <code>service</code> package.
 */
@Configuration
public class ServiceConfiguration {

    /**
     * @return A Base64 encoder.
     */
    @Bean
    @SuppressWarnings("static-method")
    public Encoder encoder() {
        return Base64.getEncoder();
    }

    /**
     * @return A Hashids instance.
     */
    @Bean
    @SuppressWarnings("static-method")
    public Hashids hashids() {
        // TODO: inject custom salt using app.property
        return new Hashids("custom salt"); //$NON-NLS-1$
    }

}
