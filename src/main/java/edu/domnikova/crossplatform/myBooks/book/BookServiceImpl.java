package edu.domnikova.crossplatform.myBooks.book;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.testcontainers.shaded.com.google.common.collect.ImmutableSet;

@Service
@Transactional
public class BookServiceImpl implements BookService{
    private final BookRepository repository;
    public BookServiceImpl(BookRepository repository) {
            this.repository = repository;
        }
        @Override
        public Book createBook(CreateBookParameters parameters) {
            BookId bookId = repository.nextId();
            Book book = new Book(bookId,
                    parameters.getTitle(),
                    parameters.getAuthor(),
                    parameters.getLanguage(),
                    parameters.getAgeRating());
            return repository.save(book);
        }

    @Override
    public Page<Book> getBooks(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ImmutableSet<Book> getAllBooks() {
        return ImmutableSet.copyOf(repository.findAll());
    }

    @Override
    public boolean BookWithTitleExist(Title title) {
        return repository.existsByTitle(title);
    }
}