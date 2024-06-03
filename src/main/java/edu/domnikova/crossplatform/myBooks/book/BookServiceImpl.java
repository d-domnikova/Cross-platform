package edu.domnikova.crossplatform.myBooks.book;

import edu.domnikova.crossplatform.myBooks.EditBookParameters;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.testcontainers.shaded.com.google.common.collect.ImmutableSet;

import java.util.Optional;

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
    public Optional<Book> getBook(BookId bookId) {
        return repository.findById(bookId);
    }

    @Override
    public ImmutableSet<Book> getAllBooks() {
        return ImmutableSet.copyOf(repository.findAll());
    }

    @Override
    public boolean BookWithTitleExist(Title title) {
        return repository.existsByTitle(title);
    }

    @Override
    public Book EditBook(BookId bookId, EditBookParameters bookParameters) {
        var book = repository
                .findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));
        if (bookParameters.getVersion() != book.getVersion()) {
            throw new ObjectOptimisticLockingFailureException(Book.class, book.getId().asString());
        }
        bookParameters.update(book);
        return book;
    }
}