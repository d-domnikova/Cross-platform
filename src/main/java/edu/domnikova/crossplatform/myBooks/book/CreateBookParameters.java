package edu.domnikova.crossplatform.myBooks.book;

import edu.domnikova.crossplatform.myBooks.book.*;

public class CreateBookParameters {
    private final Title title;
    private final Author author;
    private final Language language;
    private final AgeRating ageRating;

    public CreateBookParameters(Title title, Author author, Language language, AgeRating ageRating) {
        this.title = title;
        this.author = author;
        this.language = language;
        this.ageRating = ageRating;
    }

    public Title getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public Language getLanguage() {
        return language;
    }

    public AgeRating getAgeRating() {
        return ageRating;
    }
}
