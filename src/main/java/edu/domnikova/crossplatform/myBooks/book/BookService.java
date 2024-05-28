package edu.domnikova.crossplatform.myBooks.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Book createBook(CreateBookParameters parameters);
    Page<Book> getBooks(Pageable pageable);

}