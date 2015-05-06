/*
 * This file is part of identifier-service. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of identifier-service,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package com.github.sebhoss.identifier.testsupport;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.util.UUID;

/**
 * Verifies that a given String matches a valid UUID
 */
public final class UuidMatcher extends TypeSafeMatcher<String> {

    /**
     * @return Matcher that verifies the UUID structure.
     */
    public static final UuidMatcher isValidUUID() {
        return new UuidMatcher();
    }

    @Override
    public void describeTo(final Description description) {
        description.appendText("UUID invalid"); //$NON-NLS-1$
    }

    @Override
    protected boolean matchesSafely(final String item) {
        try {
            UUID.fromString(item);
            return true;
        } catch (final IllegalArgumentException exception) {
            return false;
        }
    }

}
