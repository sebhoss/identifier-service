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
package com.github.sebhoss.identifier.usecases;

import com.codahale.metrics.annotation.Timed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Identifiers can be retrieved as HTML.
 */
@Controller
@RequestMapping(produces = "text/html", method = RequestMethod.GET)
@SuppressWarnings("nls")
public class IndexPages {

    private final API api;

    @Autowired
    IndexPages(final API api) {
        this.api = api;
    }

    /**
     * Shows the root page which contains all possible identifiers.
     *
     * @param model
     *            The view model.
     * @return The view name for the index page.
     */
    @Timed
    @RequestMapping(HttpApi.ROOT)
    public String root(final Model model) {
        enrichSequences(model);
        enrichTimestamps(model);
        enrichUuids(model);
        return "index";
    }

    /**
     * Shows the sequence page which shows all sequence based identifiers.
     *
     * @param model
     *            The view model.
     * @return The name of the view to show.
     */
    @Timed
    @RequestMapping(HttpApi.SEQUENCES)
    public String sequences(final Model model) {
        enrichSequences(model);
        return "index";
    }

    /**
     * Shows the sequence page which only shows sequence identifiers.
     *
     * @param model
     *            The view model.
     * @return The name of the view to show.
     */
    @Timed
    @RequestMapping(HttpApi.SEQUENCE)
    public String sequence(final Model model) {
        showSequences(model);
        showSequence(model);
        return "index";
    }

    /**
     * Shows the sequence page which only shows sequence identifiers in Base36.
     *
     * @param model
     *            The view model.
     * @return The name of the view to show.
     */
    @Timed
    @RequestMapping(HttpApi.SEQUENCE_BASE36)
    public String sequence36(final Model model) {
        showSequences(model);
        showSequenceInBase36(model);
        return "index";
    }

    /**
     * Shows the sequence page which only shows sequence identifiers in Base62.
     *
     * @param model
     *            The view model.
     * @return The name of the view to show.
     */
    @Timed
    @RequestMapping(HttpApi.SEQUENCE_BASE62)
    public String sequence62(final Model model) {
        showSequences(model);
        showSequenceInBase62(model);
        return "index";
    }

    /**
     * Shows the sequence page which only shows sequence identifiers in Base64.
     *
     * @param model
     *            The view model.
     * @return The name of the view to show.
     */
    @Timed
    @RequestMapping(HttpApi.SEQUENCE_BASE64)
    public String sequence64(final Model model) {
        showSequences(model);
        showSequenceInBase64(model);
        return "index";
    }

    /**
     * Shows the sequence page which only shows sequence identifiers in Base85.
     *
     * @param model
     *            The view model.
     * @return The name of the view to show.
     */
    @Timed
    @RequestMapping(HttpApi.SEQUENCE_BASE85)
    public String sequence85(final Model model) {
        showSequences(model);
        showSequenceInBase85(model);
        return "index";
    }

    /**
     * Shows the sequence page which only shows sequence identifiers as HashId.
     *
     * @param model
     *            The view model.
     * @return The name of the view to show.
     */
    @Timed
    @RequestMapping(HttpApi.SEQUENCE_HASHID)
    public String sequenceHashId(final Model model) {
        showSequences(model);
        showSequenceAsHashId(model);
        return "index";
    }

    private void enrichSequences(final Model model) {
        showSequences(model);
        showSequence(model);
        showSequenceInBase36(model);
        showSequenceInBase62(model);
        showSequenceInBase64(model);
        showSequenceInBase85(model);
        showSequenceAsHashId(model);
    }

    private static void showSequences(final Model model) {
        model.addAttribute("sequences", Boolean.TRUE);
    }

    private void showSequence(final Model model) {
        model.addAttribute("sequence", api.nextSequence());
    }

    private void showSequenceInBase36(final Model model) {
        model.addAttribute("sequence36", api.nextSequenceInBase36());
    }

    private void showSequenceInBase62(final Model model) {
        model.addAttribute("sequence62", api.nextSequenceInBase62());
    }

    private void showSequenceInBase64(final Model model) {
        model.addAttribute("sequence64", api.nextSequenceInBase64());
    }

    private void showSequenceInBase85(final Model model) {
        model.addAttribute("sequence85", api.nextSequenceInBase85());
    }

    private void showSequenceAsHashId(final Model model) {
        model.addAttribute("sequenceHashId", api.nextSequenceAsHashId());
    }

    /**
     * Shows the timestamp page which shows all timestamp based identifiers.
     *
     * @param model
     *            The view model.
     * @return The name of the view to show.
     */
    @Timed
    @RequestMapping(HttpApi.TIMESTAMPS)
    public String timestamps(final Model model) {
        enrichTimestamps(model);
        return "index";
    }

    /**
     * Shows the timestamp page which only shows timestamp identifiers.
     *
     * @param model
     *            The view model.
     * @return The name of the view to show.
     */
    @Timed
    @RequestMapping(HttpApi.TIMESTAMP)
    public String timestamp(final Model model) {
        showTimestamps(model);
        showTimestamp(model);
        return "index";
    }

    /**
     * Shows the timestamp page which only shows timestamp identifiers in Base36.
     *
     * @param model
     *            The view model.
     * @return The name of the view to show.
     */
    @Timed
    @RequestMapping(HttpApi.TIMESTAMP_BASE36)
    public String timestamp36(final Model model) {
        showTimestamps(model);
        showTimestampInBase36(model);
        return "index";
    }

    /**
     * Shows the timestamp page which only shows timestamp identifiers in Base62.
     *
     * @param model
     *            The view model.
     * @return The name of the view to show.
     */
    @Timed
    @RequestMapping(HttpApi.TIMESTAMP_BASE62)
    public String timestamp62(final Model model) {
        showTimestamps(model);
        showTimestampInBase62(model);
        return "index";
    }

    /**
     * Shows the timestamp page which only shows timestamp identifiers in Base64.
     *
     * @param model
     *            The view model.
     * @return The name of the view to show.
     */
    @Timed
    @RequestMapping(HttpApi.TIMESTAMP_BASE64)
    public String timestamp64(final Model model) {
        showTimestamps(model);
        showTimestampInBase64(model);
        return "index";
    }

    /**
     * Shows the timestamp page which only shows timestamp identifiers in Base85.
     *
     * @param model
     *            The view model.
     * @return The name of the view to show.
     */
    @Timed
    @RequestMapping(HttpApi.TIMESTAMP_BASE85)
    public String timestamp85(final Model model) {
        showTimestamps(model);
        showTimestampInBase85(model);
        return "index";
    }

    /**
     * Shows the timestamp page which only shows timestamp identifiers as HashId.
     *
     * @param model
     *            The view model.
     * @return The name of the view to show.
     */
    @Timed
    @RequestMapping(HttpApi.TIMESTAMP_HASHID)
    public String timestampHashId(final Model model) {
        showTimestamps(model);
        showTimestampAsHashId(model);
        return "index";
    }

    private void enrichTimestamps(final Model model) {
        showTimestamps(model);
        showTimestamp(model);
        showTimestampInBase36(model);
        showTimestampInBase62(model);
        showTimestampInBase64(model);
        showTimestampInBase85(model);
        showTimestampAsHashId(model);
    }

    private static void showTimestamps(final Model model) {
        model.addAttribute("timestamps", Boolean.TRUE);
    }

    private void showTimestamp(final Model model) {
        model.addAttribute("timestamp", api.nextTimestamp());
    }

    private void showTimestampInBase36(final Model model) {
        model.addAttribute("timestamp36", api.nextTimestampInBase36());
    }

    private void showTimestampInBase62(final Model model) {
        model.addAttribute("timestamp62", api.nextTimestampInBase62());
    }

    private void showTimestampInBase64(final Model model) {
        model.addAttribute("timestamp64", api.nextTimestampInBase64());
    }

    private void showTimestampInBase85(final Model model) {
        model.addAttribute("timestamp85", api.nextTimestampInBase85());
    }

    private void showTimestampAsHashId(final Model model) {
        model.addAttribute("timestampHashId", api.nextTimestampAsHashId());
    }

    /**
     * Shows the UUID page which shows all UUID based identifiers.
     *
     * @param model
     *            The view model.
     * @return The name of the view to show.
     */
    @Timed
    @RequestMapping(HttpApi.UUIDS)
    public String uuids(final Model model) {
        enrichUuids(model);
        return "index";
    }

    /**
     * Shows the UUID page which only shows UUID identifiers.
     *
     * @param model
     *            The view model.
     * @return The name of the view to show.
     */
    @Timed
    @RequestMapping(HttpApi.UUID)
    public String uuid(final Model model) {
        showUuids(model);
        showUuid(model);
        return "index";
    }

    /**
     * Shows the UUID page which only shows UUID identifiers in Base36.
     *
     * @param model
     *            The view model.
     * @return The name of the view to show.
     */
    @Timed
    @RequestMapping(HttpApi.UUID_BASE36)
    public String uuid36(final Model model) {
        showUuids(model);
        showUuidInBase36(model);
        return "index";
    }

    /**
     * Shows the UUID page which only shows UUID identifiers in Base62.
     *
     * @param model
     *            The view model.
     * @return The name of the view to show.
     */
    @Timed
    @RequestMapping(HttpApi.UUID_BASE62)
    public String uuid62(final Model model) {
        showUuids(model);
        showUuidInBase62(model);
        return "index";
    }

    /**
     * Shows the UUID page which only shows UUID identifiers in Base64.
     *
     * @param model
     *            The view model.
     * @return The name of the view to show.
     */
    @Timed
    @RequestMapping(HttpApi.UUID_BASE64)
    public String uuid64(final Model model) {
        showUuids(model);
        showUuidInBase64(model);
        return "index";
    }

    /**
     * Shows the UUID page which only shows UUID identifiers in Base85.
     *
     * @param model
     *            The view model.
     * @return The name of the view to show.
     */
    @Timed
    @RequestMapping(HttpApi.UUID_BASE85)
    public String uuid85(final Model model) {
        showUuids(model);
        showUuidInBase85(model);
        return "index";
    }

    /**
     * Shows the UUID page which only shows UUID identifiers as HashId.
     *
     * @param model
     *            The view model.
     * @return The name of the view to show.
     */
    @Timed
    @RequestMapping(HttpApi.UUID_HASHID)
    public String uuidHashId(final Model model) {
        showUuids(model);
        showUuidAsHashId(model);
        return "index";
    }

    private void enrichUuids(final Model model) {
        showUuids(model);
        showUuid(model);
        showUuidInBase36(model);
        showUuidInBase62(model);
        showUuidInBase64(model);
        showUuidInBase85(model);
        showUuidAsHashId(model);
    }

    private static void showUuids(final Model model) {
        model.addAttribute("uuids", Boolean.TRUE);
    }

    private void showUuid(final Model model) {
        model.addAttribute("uuid", api.nextUuid());
    }

    private void showUuidInBase36(final Model model) {
        model.addAttribute("uuid36", api.nextUuidInBase36());
    }

    private void showUuidInBase62(final Model model) {
        model.addAttribute("uuid62", api.nextUuidInBase62());
    }

    private void showUuidInBase64(final Model model) {
        model.addAttribute("uuid64", api.nextUuidInBase64());
    }

    private void showUuidInBase85(final Model model) {
        model.addAttribute("uuid85", api.nextUuidInBase85());
    }

    private void showUuidAsHashId(final Model model) {
        model.addAttribute("uuidHashId", api.nextUuidAsHashId());
    }

    /**
     * The required internal API for the index page.
     */
    public static interface API extends Sequences.API, Timestamps.API, UUIDs.API {

        // see super-interfaces

    }

}
