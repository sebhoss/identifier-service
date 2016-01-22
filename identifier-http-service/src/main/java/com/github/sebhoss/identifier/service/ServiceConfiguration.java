package com.github.sebhoss.identifier.service;

import java.util.Base64;
import java.util.Base64.Encoder;

import org.hashids.Hashids;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for the classes inside the <code>service</code> package.
 */
@Configuration
public class ServiceConfiguration {

    /**
     * @return A Base64 encoder.
     */
    @Bean
    @SuppressWarnings("static-method")
    public Encoder encoder() {
        return Base64.getEncoder();
    }

    /**
     * @return A Hashids instance.
     */
    @Bean
    @SuppressWarnings("static-method")
    public Hashids hashids() {
        return new Hashids("custom salt"); //$NON-NLS-1$
    }

}
