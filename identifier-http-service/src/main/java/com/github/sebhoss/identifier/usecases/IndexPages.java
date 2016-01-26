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

import java.util.Arrays;
import java.util.function.Consumer;

import com.codahale.metrics.annotation.Timed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
        return index(model,
                api::showAllSequences,
                api::showAllTimestamps,
                api::showAllUuids);
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
        return index(model,
                api::showAllSequences);
    }

    /**
     * Shows the sequence page which only shows sequence identifiers.
     *
     * @param quantity
     *            The number of sequences to show.
     * @param model
     *            The view model.
     * @return The name of the view to show.
     */
    @Timed
    @RequestMapping(HttpApi.SEQUENCE)
    public String sequence(
            final @RequestParam(name = "quantity", required = false, defaultValue = "1") Integer quantity,
            final Model model) {
        return index(model, quantity,
                api::showSequences,
                api::showSequence);
    }

    /**
     * Shows the sequence page which only shows sequence identifiers in Base36.
     *
     * @param quantity
     *            The number of sequences to show.
     * @param model
     *            The view model.
     * @return The name of the view to show.
     */
    @Timed
    @RequestMapping(HttpApi.SEQUENCE_BASE36)
    public String sequence36(
            final @RequestParam(name = "quantity", required = false, defaultValue = "1") Integer quantity,
            final Model model) {
        return index(model, quantity,
                api::showSequences,
                api::showSequenceInBase36);
    }

    /**
     * Shows the sequence page which only shows sequence identifiers in Base62.
     *
     * @param quantity
     *            The number of sequences to show.
     * @param model
     *            The view model.
     * @return The name of the view to show.
     */
    @Timed
    @RequestMapping(HttpApi.SEQUENCE_BASE62)
    public String sequence62(
            final @RequestParam(name = "quantity", required = false, defaultValue = "1") Integer quantity,
            final Model model) {
        return index(model, quantity,
                api::showSequences,
                api::showSequenceInBase62);
    }

    /**
     * Shows the sequence page which only shows sequence identifiers in Base64.
     *
     * @param quantity
     *            The number of sequences to show.
     * @param model
     *            The view model.
     * @return The name of the view to show.
     */
    @Timed
    @RequestMapping(HttpApi.SEQUENCE_BASE64)
    public String sequence64(
            final @RequestParam(name = "quantity", required = false, defaultValue = "1") Integer quantity,
            final Model model) {
        return index(model, quantity,
                api::showSequences,
                api::showSequenceInBase64);
    }

    /**
     * Shows the sequence page which only shows sequence identifiers as HashId.
     *
     * @param quantity
     *            The number of sequences to show.
     * @param model
     *            The view model.
     * @return The name of the view to show.
     */
    @Timed
    @RequestMapping(HttpApi.SEQUENCE_HASHID)
    public String sequenceHashId(
            final @RequestParam(name = "quantity", required = false, defaultValue = "1") Integer quantity,
            final Model model) {
        return index(model, quantity,
                api::showSequences,
                api::showSequenceAsHashId);
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
        return index(model,
                api::showAllTimestamps);
    }

    /**
     * Shows the timestamp page which only shows timestamp identifiers.
     *
     * @param quantity
     *            The number of timestamps to show.
     * @param model
     *            The view model.
     * @return The name of the view to show.
     */
    @Timed
    @RequestMapping(HttpApi.TIMESTAMP)
    public String timestamp(
            final @RequestParam(name = "quantity", required = false, defaultValue = "1") Integer quantity,
            final Model model) {
        return index(model, quantity,
                api::showTimestamps,
                api::showTimestamp);
    }

    /**
     * Shows the timestamp page which only shows timestamp identifiers in Base36.
     *
     * @param quantity
     *            The number of timestamps to show.
     * @param model
     *            The view model.
     * @return The name of the view to show.
     */
    @Timed
    @RequestMapping(HttpApi.TIMESTAMP_BASE36)
    public String timestamp36(
            final @RequestParam(name = "quantity", required = false, defaultValue = "1") Integer quantity,
            final Model model) {
        return index(model, quantity,
                api::showTimestamps,
                api::showTimestampInBase36);
    }

    /**
     * Shows the timestamp page which only shows timestamp identifiers in Base62.
     *
     * @param quantity
     *            The number of timestamps to show.
     * @param model
     *            The view model.
     * @return The name of the view to show.
     */
    @Timed
    @RequestMapping(HttpApi.TIMESTAMP_BASE62)
    public String timestamp62(
            final @RequestParam(name = "quantity", required = false, defaultValue = "1") Integer quantity,
            final Model model) {
        return index(model, quantity,
                api::showTimestamps,
                api::showTimestampInBase62);
    }

    /**
     * Shows the timestamp page which only shows timestamp identifiers in Base64.
     *
     * @param quantity
     *            The number of timestamps to show.
     * @param model
     *            The view model.
     * @return The name of the view to show.
     */
    @Timed
    @RequestMapping(HttpApi.TIMESTAMP_BASE64)
    public String timestamp64(
            final @RequestParam(name = "quantity", required = false, defaultValue = "1") Integer quantity,
            final Model model) {
        return index(model, quantity,
                api::showTimestamps,
                api::showTimestampInBase64);
    }

    /**
     * Shows the timestamp page which only shows timestamp identifiers as HashId.
     *
     * @param quantity
     *            The number of timestamps to show.
     * @param model
     *            The view model.
     * @return The name of the view to show.
     */
    @Timed
    @RequestMapping(HttpApi.TIMESTAMP_HASHID)
    public String timestampHashId(
            final @RequestParam(name = "quantity", required = false, defaultValue = "1") Integer quantity,
            final Model model) {
        return index(model, quantity,
                api::showTimestamps,
                api::showTimestampAsHashId);
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
        return index(model,
                api::showAllUuids);
    }

    /**
     * Shows the UUID page which only shows UUID identifiers.
     *
     * @param quantity
     *            The number of UUIDs to show.
     * @param model
     *            The view model.
     * @return The name of the view to show.
     */
    @Timed
    @RequestMapping(HttpApi.UUID)
    public String uuid(
            final @RequestParam(name = "quantity", required = false, defaultValue = "1") Integer quantity,
            final Model model) {
        return index(model, quantity,
                api::showUuids,
                api::showUuid);
    }

    /**
     * Shows the UUID page which only shows UUID identifiers in Base36.
     *
     * @param quantity
     *            The number of UUIDs to show.
     * @param model
     *            The view model.
     * @return The name of the view to show.
     */
    @Timed
    @RequestMapping(HttpApi.UUID_BASE36)
    public String uuid36(
            final @RequestParam(name = "quantity", required = false, defaultValue = "1") Integer quantity,
            final Model model) {
        return index(model, quantity,
                api::showUuids,
                api::showUuidInBase36);
    }

    /**
     * Shows the UUID page which only shows UUID identifiers in Base62.
     *
     * @param quantity
     *            The number of UUIDs to show.
     * @param model
     *            The view model.
     * @return The name of the view to show.
     */
    @Timed
    @RequestMapping(HttpApi.UUID_BASE62)
    public String uuid62(
            final @RequestParam(name = "quantity", required = false, defaultValue = "1") Integer quantity,
            final Model model) {
        return index(model, quantity,
                api::showUuids,
                api::showUuidInBase62);
    }

    /**
     * Shows the UUID page which only shows UUID identifiers in Base64.
     *
     * @param quantity
     *            The number of UUIDs to show.
     * @param model
     *            The view model.
     * @return The name of the view to show.
     */
    @Timed
    @RequestMapping(HttpApi.UUID_BASE64)
    public String uuid64(
            final @RequestParam(name = "quantity", required = false, defaultValue = "1") Integer quantity,
            final Model model) {
        return index(model, quantity,
                api::showUuids,
                api::showUuidInBase64);
    }

    /**
     * Shows the UUID page which only shows UUID identifiers as HashId.
     *
     * @param quantity
     *            The number of UUIDs to show.
     * @param model
     *            The view model.
     * @return The name of the view to show.
     */
    @Timed
    @RequestMapping(HttpApi.UUID_HASHID)
    public String uuidHashId(
            final @RequestParam(name = "quantity", required = false, defaultValue = "1") Integer quantity,
            final Model model) {
        return index(model, quantity,
                api::showUuids,
                api::showUuidAsHashId);
    }

    @SafeVarargs
    private static String index(final Model model, final Consumer<Model>... consumers) {
        return index(model, null, consumers);
    }

    @SafeVarargs
    private static String index(final Model model, final Integer quantity, final Consumer<Model>... consumers) {
        Arrays.stream(consumers).forEach(consumer -> consumer.accept(model));
        model.addAttribute("quantity", quantity);
        return "index"; // delegates to the 'index' template
    }

    /**
     * The required internal API for the index page.
     */
    public static interface API {

        /**
         * @param model
         *            The model to adapt.
         */
        void showAllSequences(Model model);

        /**
         * @param model
         *            The model to adapt.
         */
        void showSequences(Model model);

        /**
         * @param model
         *            The model to adapt.
         */
        void showSequence(Model model);

        /**
         * @param model
         *            The model to adapt.
         */
        void showSequenceInBase36(Model model);

        /**
         * @param model
         *            The model to adapt.
         */
        void showSequenceInBase62(Model model);

        /**
         * @param model
         *            The model to adapt.
         */
        void showSequenceInBase64(Model model);

        /**
         * @param model
         *            The model to adapt.
         */
        void showSequenceAsHashId(Model model);

        /**
         * @param model
         *            The model to adapt.
         */
        void showAllTimestamps(Model model);

        /**
         * @param model
         *            The model to adapt.
         */
        void showTimestamps(Model model);

        /**
         * @param model
         *            The model to adapt.
         */
        void showTimestamp(Model model);

        /**
         * @param model
         *            The model to adapt.
         */
        void showTimestampInBase36(Model model);

        /**
         * @param model
         *            The model to adapt.
         */
        void showTimestampInBase62(Model model);

        /**
         * @param model
         *            The model to adapt.
         */
        void showTimestampInBase64(Model model);

        /**
         * @param model
         *            The model to adapt.
         */
        void showTimestampAsHashId(Model model);

        /**
         * @param model
         *            The model to adapt.
         */
        void showAllUuids(Model model);

        /**
         * @param model
         *            The model to adapt.
         */
        void showUuids(Model model);

        /**
         * @param model
         *            The model to adapt.
         */
        void showUuid(Model model);

        /**
         * @param model
         *            The model to adapt.
         */
        void showUuidInBase36(Model model);

        /**
         * @param model
         *            The model to adapt.
         */
        void showUuidInBase62(Model model);

        /**
         * @param model
         *            The model to adapt.
         */
        void showUuidInBase64(Model model);

        /**
         * @param model
         *            The model to adapt.
         */
        void showUuidAsHashId(Model model);

    }

}
