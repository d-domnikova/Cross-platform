package edu.domnikova.crossplatform.myBooks.book;

import org.springframework.util.Assert;
import org.testcontainers.shaded.com.google.common.base.MoreObjects;

import java.util.Objects;

public class Author {
    private String name;
    protected Author(){}

    public Author(String name) {
        Assert.hasText(name, "Author's name cannot be blank.");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String asString() {
        return name;
    }
}