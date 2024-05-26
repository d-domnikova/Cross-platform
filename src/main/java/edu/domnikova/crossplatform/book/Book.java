package edu.domnikova.crossplatform.book;

import io.github.wimdeblauwe.jpearl.AbstractEntity;

import jakarta.persistence.Entity;

@Entity
public class Book extends AbstractEntity<BookId> {

    /**
     * Default constructor for JPA
     */
    protected Book() {
    }

    public Book(BookId id) {
        super(id);
    }
}