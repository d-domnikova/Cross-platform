package edu.domnikova.crossplatform.myBooks.book;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(BookId bookId) {
        super(String.format("Book with id %s not found", bookId.asString()));
    }
}
