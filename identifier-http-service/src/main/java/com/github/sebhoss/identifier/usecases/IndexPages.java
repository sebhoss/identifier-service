/*
 * This file is part of identifier-service. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of identifier-service,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package com.github.sebhoss.identifier.usecases;

import com.codahale.metrics.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.function.Consumer;

import static com.github.sebhoss.identifier.usecases.HttpApi.ROOT;
import static com.github.sebhoss.identifier.usecases.HttpApi.SEQUENCE;
import static com.github.sebhoss.identifier.usecases.HttpApi.SEQUENCES;
import static com.github.sebhoss.identifier.usecases.HttpApi.SEQUENCE_BASE36;
import static com.github.sebhoss.identifier.usecases.HttpApi.SEQUENCE_BASE62;
import static com.github.sebhoss.identifier.usecases.HttpApi.SEQUENCE_BASE64;
import static com.github.sebhoss.identifier.usecases.HttpApi.SEQUENCE_HASHID;
import static com.github.sebhoss.identifier.usecases.HttpApi.TIMESTAMP;
import static com.github.sebhoss.identifier.usecases.HttpApi.TIMESTAMPS;
import static com.github.sebhoss.identifier.usecases.HttpApi.TIMESTAMP_BASE36;
import static com.github.sebhoss.identifier.usecases.HttpApi.TIMESTAMP_BASE62;
import static com.github.sebhoss.identifier.usecases.HttpApi.TIMESTAMP_BASE64;
import static com.github.sebhoss.identifier.usecases.HttpApi.TIMESTAMP_HASHID;
import static com.github.sebhoss.identifier.usecases.HttpApi.UUID;
import static com.github.sebhoss.identifier.usecases.HttpApi.UUIDS;
import static com.github.sebhoss.identifier.usecases.HttpApi.UUID_BASE36;
import static com.github.sebhoss.identifier.usecases.HttpApi.UUID_BASE62;
import static com.github.sebhoss.identifier.usecases.HttpApi.UUID_BASE64;
import static com.github.sebhoss.identifier.usecases.HttpApi.UUID_HASHID;
import static com.github.sebhoss.identifier.usecases.RequestParameters.DEFAULT_QUANTITY;
import static com.github.sebhoss.identifier.usecases.RequestParameters.QUANTITY;
import static org.springframework.http.MediaType.TEXT_HTML_VALUE;

/**
 * Identifiers can be retrieved as HTML.
 */
@Controller
@SuppressWarnings("nls")
@RequestMapping(produces = TEXT_HTML_VALUE, method = RequestMethod.GET)
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
    @RequestMapping(ROOT)
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
    @RequestMapping(SEQUENCES)
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
    @RequestMapping(SEQUENCE)
    public String sequence(
            final @RequestParam(name = QUANTITY, required = false, defaultValue = DEFAULT_QUANTITY) Integer quantity,
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
    @RequestMapping(SEQUENCE_BASE36)
    public String sequence36(
            final @RequestParam(name = QUANTITY, required = false, defaultValue = DEFAULT_QUANTITY) Integer quantity,
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
    @RequestMapping(SEQUENCE_BASE62)
    public String sequence62(
            final @RequestParam(name = QUANTITY, required = false, defaultValue = DEFAULT_QUANTITY) Integer quantity,
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
    @RequestMapping(SEQUENCE_BASE64)
    public String sequence64(
            final @RequestParam(name = QUANTITY, required = false, defaultValue = DEFAULT_QUANTITY) Integer quantity,
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
    @RequestMapping(SEQUENCE_HASHID)
    public String sequenceHashId(
            final @RequestParam(name = QUANTITY, required = false, defaultValue = DEFAULT_QUANTITY) Integer quantity,
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
    @RequestMapping(TIMESTAMPS)
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
    @RequestMapping(TIMESTAMP)
    public String timestamp(
            final @RequestParam(name = QUANTITY, required = false, defaultValue = DEFAULT_QUANTITY) Integer quantity,
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
    @RequestMapping(TIMESTAMP_BASE36)
    public String timestamp36(
            final @RequestParam(name = QUANTITY, required = false, defaultValue = DEFAULT_QUANTITY) Integer quantity,
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
    @RequestMapping(TIMESTAMP_BASE62)
    public String timestamp62(
            final @RequestParam(name = QUANTITY, required = false, defaultValue = DEFAULT_QUANTITY) Integer quantity,
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
    @RequestMapping(TIMESTAMP_BASE64)
    public String timestamp64(
            final @RequestParam(name = QUANTITY, required = false, defaultValue = DEFAULT_QUANTITY) Integer quantity,
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
    @RequestMapping(TIMESTAMP_HASHID)
    public String timestampHashId(
            final @RequestParam(name = QUANTITY, required = false, defaultValue = DEFAULT_QUANTITY) Integer quantity,
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
    @RequestMapping(UUIDS)
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
    @RequestMapping(UUID)
    public String uuid(
            final @RequestParam(name = QUANTITY, required = false, defaultValue = DEFAULT_QUANTITY) Integer quantity,
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
    @RequestMapping(UUID_BASE36)
    public String uuid36(
            final @RequestParam(name = QUANTITY, required = false, defaultValue = DEFAULT_QUANTITY) Integer quantity,
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
    @RequestMapping(UUID_BASE62)
    public String uuid62(
            final @RequestParam(name = QUANTITY, required = false, defaultValue = DEFAULT_QUANTITY) Integer quantity,
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
    @RequestMapping(UUID_BASE64)
    public String uuid64(
            final @RequestParam(name = QUANTITY, required = false, defaultValue = DEFAULT_QUANTITY) Integer quantity,
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
    @RequestMapping(UUID_HASHID)
    public String uuidHashId(
            final @RequestParam(name = QUANTITY, required = false, defaultValue = DEFAULT_QUANTITY) Integer quantity,
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
        model.addAttribute(QUANTITY, quantity);
        return "index"; // delegates to the 'index' template
    }

    /**
     * The required internal API for the index page.
     */
    public interface API {

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
