/*
 * This file is part of identifier-service. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of identifier-service,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package com.github.sebhoss.identifier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Small "micro"-service like application that allows its users to retrieve identifiers.
 */
@SpringBootApplication
public class IdentifierApplication {

    /**
     * Starts the id-service.
     *
     * @param args
     *            The command line arguments.
     */
    public static void main(final String[] args) {
        SpringApplication.run(IdentifierApplication.class, args);
    }

}
