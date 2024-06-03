package edu.domnikova.crossplatform.myBooks.book;

import io.github.wimdeblauwe.jpearl.AbstractVersionedEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tt_books")
public class Book extends AbstractVersionedEntity<BookId> {
    @NotNull
    @Convert(converter = TitleAttributeConverter.class)
    private Title title;
    @NotNull
    @Convert(converter = AuthorAttributeConverter.class)
    private Author author;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Language language;
    @NotNull
    @Enumerated(EnumType.STRING)
    private AgeRating ageRating;

    protected Book() {
    }

    public Book(BookId id, Title title, Author author, Language language, AgeRating ageRating) {
        super(id);
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

    public void setTitle(Title title) {
        this.title = title;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public void setAgeRating(AgeRating ageRating) {
        this.ageRating = ageRating;
    }
}