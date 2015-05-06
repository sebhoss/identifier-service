/*
 * This file is part of identifier-service. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of identifier-service,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package com.github.sebhoss.identifier.application;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

/**
 *
 *
 */
@Component
public class ThymeleafCustomizer {

    private final ThymeleafViewResolver viewResolver;
    private final ApplicationProperties properties;

    /**
     * @param viewResolver
     *            The view-resolver to configure.
     * @param properties
     *            The properties to use.
     */
    @Autowired
    public ThymeleafCustomizer(
            final ThymeleafViewResolver viewResolver,
            final ApplicationProperties properties) {
        this.viewResolver = viewResolver;
        this.properties = properties;
    }

    @PostConstruct
    void afterConstruction() {
        viewResolver.addStaticVariable("HOST", properties.getUrl()); //$NON-NLS-1$
    }

}
