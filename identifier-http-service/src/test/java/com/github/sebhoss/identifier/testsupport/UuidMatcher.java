package com.github.sebhoss.identifier.testsupport;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.util.UUID;

/**
 * Verifies that a given String matches a valid UUID
 */
public class UuidMatcher extends TypeSafeMatcher<String> {

    public static final UuidMatcher isValidUUID() {
        return new UuidMatcher();
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("UUID invalid");
    }

    @Override
    protected boolean matchesSafely(String item) {
        try {
            UUID.fromString(item);
            return true;
        } catch (IllegalArgumentException exception) {
            return false;
        }
    }

}
