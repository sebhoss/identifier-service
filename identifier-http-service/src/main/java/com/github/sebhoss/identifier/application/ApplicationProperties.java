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

}
