/*
 * This file is part of identifier-service. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of identifier-service,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package com.github.sebhoss.identifier.usecases;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import com.github.sebhoss.identifier.testsupport.AbstractIntegrationTest;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Integration test for {@link IndexPages}.
 */
public class IndexPagesIT extends AbstractIntegrationTest {

    /**
     * Ensures that the index page can be access at <code>/</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetIndexPage() throws Exception {
        final ResponseEntity<String> response = fetchString("/"); //$NON-NLS-1$
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

}
