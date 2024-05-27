package edu.domnikova.crossplatform.myBooks.book;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface BookRepository extends CrudRepository<Book, BookId>, BookRepositoryCustom {
}