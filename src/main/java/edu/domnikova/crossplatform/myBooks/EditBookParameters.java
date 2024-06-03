package edu.domnikova.crossplatform.myBooks;

import edu.domnikova.crossplatform.myBooks.book.*;

public class EditBookParameters extends CreateBookParameters {
    private final long version;
    public EditBookParameters(long version, Title title, Author author, Language language, AgeRating ageRating) {
        super(title, author, language, ageRating);
        this.version = version;
    }

    public long getVersion() {
        return version;
    }

    public void update(Book book){
        book.setTitle(getTitle());
        book.setAuthor(getAuthor());
        book.setLanguage(getLanguage());
        book.setAgeRating(getAgeRating());
    }
}
