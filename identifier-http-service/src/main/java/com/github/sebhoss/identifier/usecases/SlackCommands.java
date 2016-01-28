package com.github.sebhoss.identifier.usecases;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.codahale.metrics.annotation.Timed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Slack commands can be answered.
 */
@Controller
@SuppressWarnings("nls")
public class SlackCommands {

    private final Map<String, Supplier<String>> suppliers;

    @Autowired
    SlackCommands(final API api) {
        suppliers = new HashMap<>();
        suppliers.put("/sequence", api::nextSequence);
        suppliers.put("/sequence-in-base36", api::nextSequenceInBase36);
        suppliers.put("/sequence-in-base62", api::nextSequenceInBase62);
        suppliers.put("/sequence-in-base64", api::nextSequenceInBase64);
        suppliers.put("/sequence-as-hashid", api::nextSequenceAsHashId);
        suppliers.put("/timestamp", api::nextTimestamp);
        suppliers.put("/timestamp-in-base36", api::nextTimestampInBase36);
        suppliers.put("/timestamp-in-base62", api::nextTimestampInBase62);
        suppliers.put("/timestamp-in-base64", api::nextTimestampInBase64);
        suppliers.put("/timestamp-as-hashid", api::nextTimestampAsHashId);
        suppliers.put("/uuid", api::nextUuid);
        suppliers.put("/uuid-in-base36", api::nextUuidInBase36);
        suppliers.put("/uuid-in-base62", api::nextUuidInBase62);
        suppliers.put("/uuid-in-base64", api::nextUuidInBase64);
        suppliers.put("/uuid-as-hashid", api::nextUuidAsHashId);
    }

    /**
     * Shows the root page which contains all possible identifiers.
     *
     * @param command
     *            The command to execute/respond-to.
     * @return The view name for the index page.
     */
    @Timed
    @ResponseBody
    @RequestMapping(path = HttpApi.SLACK)
    public String customCommands(final SlackCommand command) {
        try {
            int quantity = Integer.parseInt(command.getText());
            if (quantity < 1) {
                quantity = 1;
            }
            return Multiplier.multiple(quantity, suppliers.get(command.getCommand()));
        } catch (final NumberFormatException exception) {
            return "That's not a number " + command.getUser_name() + "!";
        }
    }

    static final class SlackCommand {

        private String command;
        private String text;
        private String token;
        private String team_id;
        private String team_domain;
        private String channel_id;
        private String channel_name;
        private String user_id;
        private String user_name;
        private String response_url;

        /**
         * @return the command
         */
        public String getCommand() {
            return command;
        }

        /**
         * @param command
         *            the command to set
         */
        public void setCommand(final String command) {
            this.command = command;
        }

        /**
         * @return the text
         */
        public String getText() {
            return text;
        }

        /**
         * @param text
         *            the text to set
         */
        public void setText(final String text) {
            this.text = text;
        }

        /**
         * @return the token
         */
        public String getToken() {
            return token;
        }

        /**
         * @param token
         *            the token to set
         */
        public void setToken(final String token) {
            this.token = token;
        }

        /**
         * @return the team_id
         */
        public String getTeam_id() {
            return team_id;
        }

        /**
         * @param team_id
         *            the team_id to set
         */
        public void setTeam_id(final String team_id) {
            this.team_id = team_id;
        }

        /**
         * @return the team_domain
         */
        public String getTeam_domain() {
            return team_domain;
        }

        /**
         * @param team_domain
         *            the team_domain to set
         */
        public void setTeam_domain(final String team_domain) {
            this.team_domain = team_domain;
        }

        /**
         * @return the channel_id
         */
        public String getChannel_id() {
            return channel_id;
        }

        /**
         * @param channel_id
         *            the channel_id to set
         */
        public void setChannel_id(final String channel_id) {
            this.channel_id = channel_id;
        }

        /**
         * @return the channel_name
         */
        public String getChannel_name() {
            return channel_name;
        }

        /**
         * @param channel_name
         *            the channel_name to set
         */
        public void setChannel_name(final String channel_name) {
            this.channel_name = channel_name;
        }

        /**
         * @return the user_id
         */
        public String getUser_id() {
            return user_id;
        }

        /**
         * @param user_id
         *            the user_id to set
         */
        public void setUser_id(final String user_id) {
            this.user_id = user_id;
        }

        /**
         * @return the user_name
         */
        public String getUser_name() {
            return user_name;
        }

        /**
         * @param user_name
         *            the user_name to set
         */
        public void setUser_name(final String user_name) {
            this.user_name = user_name;
        }

        /**
         * @return the response_url
         */
        public String getResponse_url() {
            return response_url;
        }

        /**
         * @param response_url
         *            the response_url to set
         */
        public void setResponse_url(final String response_url) {
            this.response_url = response_url;
        }

    }

    /**
     * The required internal API to generate sequences.
     */
    public static interface API extends Sequences.API, Timestamps.API, UUIDs.API {

        // see super interfaces

    }

}
