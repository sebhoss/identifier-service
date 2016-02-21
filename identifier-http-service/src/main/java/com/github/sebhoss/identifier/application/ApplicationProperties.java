/*
 * This file is part of identifier-service. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of identifier-service,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package com.github.sebhoss.identifier.application;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Application related properties
 */
@Component
@ConfigurationProperties("application")
public class ApplicationProperties {

    private String url;
    private Slack  slack;

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     *            the url to set
     */
    public void setUrl(final String url) {
        this.url = url;
    }

    /**
     * @return the slack
     */
    public Slack getSlack() {
        return slack;
    }

    /**
     * @param slack
     *            the slack to set
     */
    public void setSlack(final Slack slack) {
        this.slack = slack;
    }

    /**
     *
     */
    public static class Slack {

        private String messagePrefix;

        /**
         * @return the messagePrefix
         */
        public String getMessagePrefix() {
            return messagePrefix;
        }

        /**
         * @param messagePrefix
         *            the messagePrefix to set
         */
        public void setMessagePrefix(final String messagePrefix) {
            this.messagePrefix = messagePrefix;
        }

    }

}
