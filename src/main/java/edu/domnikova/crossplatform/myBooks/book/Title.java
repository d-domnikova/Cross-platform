package edu.domnikova.crossplatform.myBooks.book;

import org.springframework.util.Assert;
import org.testcontainers.shaded.com.google.common.base.MoreObjects;

import java.util.Objects;

public class Title {
    private String title;
    protected Title(){}

    public Title(String title) {
        Assert.hasText(title, "Title cannot be blank.");
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("title", title)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Title otherTitle = (Title) o;
        return Objects.equals(title, otherTitle.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    public String asString() {
        return title;
    }
}