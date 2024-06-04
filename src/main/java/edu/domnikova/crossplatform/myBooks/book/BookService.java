package edu.domnikova.crossplatform.myBooks.book;

import edu.domnikova.crossplatform.myBooks.EditBookParameters;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.testcontainers.shaded.com.google.common.collect.ImmutableSet;

import java.util.Optional;

public interface BookService {
    Book createBook(CreateBookParameters parameters);
    Page<Book> getBooks(Pageable pageable);
    Optional<Book> getBook(BookId bookId);
    ImmutableSet<Book> getAllBooks();
    boolean BookWithTitleExist(Title title);
    Book editBook(BookId bookId, EditBookParameters editBookParameters);
}