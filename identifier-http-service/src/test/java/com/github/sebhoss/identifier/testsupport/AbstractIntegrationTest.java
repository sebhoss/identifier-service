/*
 * This file is part of identifier-service. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of identifier-service,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package com.github.sebhoss.identifier.testsupport;

import com.github.sebhoss.identifier.IdentifierApplication;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

/**
 * Abstract integration test that sets up a Spring context of the entire application + ways to access the identifier
 * service.
 */
@WebIntegrationTest(randomPort = true)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = IdentifierApplication.class)
public abstract class AbstractIntegrationTest {

    @Value("${local.server.port}")
    private int            port;

    protected String       base;
    protected RestTemplate template;

    /**
     * set up the base URL of the service + the RestTemplate to connect to it.
     *
     * @throws Exception
     *             In case something goes wrong
     */
    @Before
    public void setUp() throws Exception {
        base = "http://localhost:" + port; //$NON-NLS-1$
        template = new TestRestTemplate();
    }

    protected final ResponseEntity<String> fetchString(final String path) {
        return template.getForEntity(base + path, String.class);
    }

}
