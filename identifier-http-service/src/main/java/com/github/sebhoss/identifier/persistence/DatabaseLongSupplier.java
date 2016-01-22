package com.github.sebhoss.identifier.persistence;

import org.springframework.stereotype.Repository;

import java.util.function.LongSupplier;

@Repository
class DatabaseLongSupplier implements LongSupplier {

    @Override
    public long getAsLong() {
        // TODO Auto-generated method stub
        return 0;
    }

}
