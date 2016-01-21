package com.github.sebhoss.identifier.persistence;

/**
 * More or less a helper class to delegate ID generation to a database (e.g. a database sequence)
 */
public interface IdentifierRepository {

    /**
     * @return The next unique identifier (BIGSERIAL based)
     */
    long nextSequenceValue();

}
