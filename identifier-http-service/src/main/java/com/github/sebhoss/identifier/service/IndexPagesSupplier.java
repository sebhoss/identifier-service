/*
 * This file is part of identifier-service. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of identifier-service,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package com.github.sebhoss.identifier.service;

import com.github.sebhoss.identifier.usecases.IndexPages;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

/**
 *
 *
 */
@Service
@SuppressWarnings("nls")
public class IndexPagesSupplier implements IndexPages.API {

    private static final String SEQUENCE  = "sequence";
    private static final String TIMESTAMP = "timestamp";
    private static final String UUID      = "uuid";
    private static final String MULTIPLE  = "s";
    private static final String BASE36    = "36";
    private static final String BASE62    = "62";
    private static final String BASE64    = "64";
    private static final String HASHID    = "HashId";

    @Override
    public void showAllSequences(final Model model) {
        showSequences(model);
        showSequence(model);
        showSequenceInBase36(model);
        showSequenceInBase62(model);
        showSequenceInBase64(model);
        showSequenceAsHashId(model);
    }

    @Override
    public void showSequences(final Model model) {
        show(model, SEQUENCE + MULTIPLE);
    }

    @Override
    public void showSequence(final Model model) {
        show(model, SEQUENCE);
    }

    @Override
    public void showSequenceInBase36(final Model model) {
        show(model, SEQUENCE + BASE36);
    }

    @Override
    public void showSequenceInBase62(final Model model) {
        show(model, SEQUENCE + BASE62);
    }

    @Override
    public void showSequenceInBase64(final Model model) {
        show(model, SEQUENCE + BASE64);
    }

    @Override
    public void showSequenceAsHashId(final Model model) {
        show(model, SEQUENCE + HASHID);
    }

    @Override
    public void showAllTimestamps(final Model model) {
        showTimestamps(model);
        showTimestamp(model);
        showTimestampInBase36(model);
        showTimestampInBase62(model);
        showTimestampInBase64(model);
        showTimestampAsHashId(model);
    }

    @Override
    public void showTimestamps(final Model model) {
        show(model, TIMESTAMP + MULTIPLE);
    }

    @Override
    public void showTimestamp(final Model model) {
        show(model, TIMESTAMP);
    }

    @Override
    public void showTimestampInBase36(final Model model) {
        show(model, TIMESTAMP + BASE36);
    }

    @Override
    public void showTimestampInBase62(final Model model) {
        show(model, TIMESTAMP + BASE62);
    }

    @Override
    public void showTimestampInBase64(final Model model) {
        show(model, TIMESTAMP + BASE64);
    }

    @Override
    public void showTimestampAsHashId(final Model model) {
        show(model, TIMESTAMP + HASHID);
    }

    @Override
    public void showAllUuids(final Model model) {
        showUuids(model);
        showUuid(model);
        showUuidInBase36(model);
        showUuidInBase62(model);
        showUuidInBase64(model);
        showUuidAsHashId(model);
    }

    @Override
    public void showUuids(final Model model) {
        show(model, UUID + MULTIPLE);
    }

    @Override
    public void showUuid(final Model model) {
        show(model, UUID);
    }

    @Override
    public void showUuidInBase36(final Model model) {
        show(model, UUID + BASE36);
    }

    @Override
    public void showUuidInBase62(final Model model) {
        show(model, UUID + BASE62);
    }

    @Override
    public void showUuidInBase64(final Model model) {
        show(model, UUID + BASE64);
    }

    @Override
    public void showUuidAsHashId(final Model model) {
        show(model, UUID + HASHID);
    }

    private static void show(final Model model, final String property) {
        model.addAttribute(property, Boolean.TRUE);
    }

}
