package edu.domnikova.crossplatform.myBooks.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.testcontainers.shaded.com.google.common.collect.ImmutableSet;

public interface BookService {
    Book createBook(CreateBookParameters parameters);
    Page<Book> getBooks(Pageable pageable);
    ImmutableSet<Book> getAllBooks();
    boolean BookWithTitleExist(Title title);
}