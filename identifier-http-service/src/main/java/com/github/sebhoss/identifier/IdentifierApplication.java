package com.github.sebhoss.identifier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Small "micro"-service like application that allows its users to retrieve identifiers.
 */
@SpringBootApplication
public class IdentifierApplication {

    public static void main(final String[] args) {
        SpringApplication.run(IdentifierApplication.class, args);
    }

}
