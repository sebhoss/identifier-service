/*
 * This file is part of identifier-service. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of identifier-service,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package com.github.sebhoss.identifier.usecases;

import com.github.sebhoss.identifier.testsupport.AbstractMockMvcTest;

import org.junit.Test;

/**
 * Unit test for {@link IndexPages}.
 */
@SuppressWarnings("nls")
public class IndexPagesTest extends AbstractMockMvcTest<IndexPages, IndexPages.API> {

    /**
     * Provides the superclass with required infrastructure.
     */
    public IndexPagesTest() {
        super(IndexPages::new, IndexPages.API.class);
    }

    /**
     * Ensures that an HTML index page can be access at <code>/</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetIndexPage() throws Exception {
        verifyHtml("/");
    }

    /**
     * Ensures that an HTML index page can be access at <code>/sequences</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetSequencesIndexPage() throws Exception {
        verifyHtml("/sequences");
    }

    /**
     * Ensures that an HTML index page can be access at <code>/sequences/sequence</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetSequenceIndexPage() throws Exception {
        verifyHtml("/sequences/sequence");
    }

    /**
     * Ensures that an HTML index page can be access at <code>/sequences/base36</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetSequenceBase36IndexPage() throws Exception {
        verifyHtml("/sequences/base36");
    }

    /**
     * Ensures that an HTML index page can be access at <code>/sequences/base62</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetSequenceBase62IndexPage() throws Exception {
        verifyHtml("/sequences/base62");
    }

    /**
     * Ensures that an HTML index page can be access at <code>/sequences/base64</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetSequenceBase64IndexPage() throws Exception {
        verifyHtml("/sequences/base64");
    }

    /**
     * Ensures that an HTML index page can be access at <code>/sequences/hashid</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetSequenceHashIdIndexPage() throws Exception {
        verifyHtml("/sequences/hashid");
    }

    /**
     * Ensures that an HTML index page can be access at <code>/timestamps</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetTimestampsIndexPage() throws Exception {
        verifyHtml("/timestamps");
    }

    /**
     * Ensures that an HTML index page can be access at <code>/timestamps/timestamp</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetTimestampIndexPage() throws Exception {
        verifyHtml("/timestamps/timestamp");
    }

    /**
     * Ensures that an HTML index page can be access at <code>/timestamps/base36</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetTimestampBase36IndexPage() throws Exception {
        verifyHtml("/timestamps/base36");
    }

    /**
     * Ensures that an HTML index page can be access at <code>/timestamps/base62</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetTimestampBase62IndexPage() throws Exception {
        verifyHtml("/timestamps/base62");
    }

    /**
     * Ensures that an HTML index page can be access at <code>/timestamps/base64</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetTimestampBase64IndexPage() throws Exception {
        verifyHtml("/timestamps/base64");
    }

    /**
     * Ensures that an HTML index page can be access at <code>/timestamps/hashid</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetTimestampHashIdIndexPage() throws Exception {
        verifyHtml("/timestamps/hashid");
    }

    /**
     * Ensures that an HTML index page can be access at <code>/uuids</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetUuidsIndexPage() throws Exception {
        verifyHtml("/uuids");
    }

    /**
     * Ensures that an HTML index page can be access at <code>/uuids/uuid</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetUuidIndexPage() throws Exception {
        verifyHtml("/uuids/uuid");
    }

    /**
     * Ensures that an HTML index page can be access at <code>/uuids/base36</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetUuidBase36IndexPage() throws Exception {
        verifyHtml("/uuids/base36");
    }

    /**
     * Ensures that an HTML index page can be access at <code>/uuids/base62</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetUuidBase62IndexPage() throws Exception {
        verifyHtml("/uuids/base62");
    }

    /**
     * Ensures that an HTML index page can be access at <code>/uuids/base64</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetUuidBase64IndexPage() throws Exception {
        verifyHtml("/uuids/base64");
    }

    /**
     * Ensures that an HTML index page can be access at <code>/uuids/hashid</code>.
     *
     * @throws Exception
     *             In case something goes wrong.
     */
    @Test
    public void shouldGetUuidHashIdIndexPage() throws Exception {
        verifyHtml("/uuids/hashid");
    }

}
