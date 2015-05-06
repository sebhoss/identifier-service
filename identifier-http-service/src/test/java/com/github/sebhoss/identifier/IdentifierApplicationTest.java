/*
 * This file is part of identifier-service. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of identifier-service,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package com.github.sebhoss.identifier;

import org.junit.Test;

/**
 * Unit test for {@link IdentifierApplication}.
 */
public class IdentifierApplicationTest {

    /**
     * Ensures that the main method exists.
     */
    @Test
    @SuppressWarnings("static-method")
    public void shouldHavePublicMainMethod() {
        IdentifierApplication.main(new String[] {});
    }

}
