/*
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 *
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * For more information, please refer to <http://unlicense.org>
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
        model.addAttribute(SEQUENCE + MULTIPLE, Boolean.TRUE);
    }

    @Override
    public void showSequence(final Model model) {
        model.addAttribute(SEQUENCE, Boolean.TRUE);
    }

    @Override
    public void showSequenceInBase36(final Model model) {
        model.addAttribute(SEQUENCE + BASE36, Boolean.TRUE);
    }

    @Override
    public void showSequenceInBase62(final Model model) {
        model.addAttribute(SEQUENCE + BASE62, Boolean.TRUE);
    }

    @Override
    public void showSequenceInBase64(final Model model) {
        model.addAttribute(SEQUENCE + BASE64, Boolean.TRUE);
    }

    @Override
    public void showSequenceAsHashId(final Model model) {
        model.addAttribute(SEQUENCE + HASHID, Boolean.TRUE);
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
