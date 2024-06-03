package edu.domnikova.crossplatform.myBooks;

import edu.domnikova.crossplatform.myBooks.book.Author;
import edu.domnikova.crossplatform.myBooks.book.Book;
import edu.domnikova.crossplatform.myBooks.book.Title;

public class EditBookFromData extends CreateBookFromData{
    private String id;

    private long version;

    public static EditBookFromData fromBook(Book book) {
        EditBookFromData result = new EditBookFromData();
        result.setId(book.getId().asString());
        result.setVersion(book.getVersion());
        result.setTitle(book.getTitle().asString());
        result.setAuthor(book.getAuthor().asString());
        result.setLanguage(book.getLanguage());
        result.setAgeRating(book.getAgeRating());
        return result;
    }

    public EditBookParameters toParameters() {
        return new EditBookParameters(
                version, new Title(getTitle()), new Author(getAuthor()),
                getLanguage(), getAgeRating()
        );
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
