package edu.domnikova.crossplatform.book;

import io.github.wimdeblauwe.jpearl.UniqueIdGenerator;

import java.util.UUID;

public class BookRepositoryImpl implements BookRepositoryCustom {
    private final UniqueIdGenerator<UUID> generator;

    public BookRepositoryImpl(UniqueIdGenerator<UUID> generator) {
        this.generator = generator;
    }

    @Override
    public BookId nextId() {
        return new BookId(generator.getNextUniqueId());
    }
}