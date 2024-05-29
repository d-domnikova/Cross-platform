package edu.domnikova.crossplatform.myBooks.book;

import io.github.wimdeblauwe.jpearl.InMemoryUniqueIdGenerator;
import io.github.wimdeblauwe.jpearl.UniqueIdGenerator;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("data-jpa-test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BookRepositoryTest {
    private final BookRepository repository;
    private final JdbcTemplate jdbcTemplate;
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    BookRepositoryTest(BookRepository repository,
                           JdbcTemplate jdbcTemplate) {
        this.repository = repository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @BeforeEach
    void validatePreconditions() {
        assertThat(repository.count()).isZero();
    }

    @Test
    void testSaveBook() {
        BookId id = repository.nextId();
        repository.save(new Book(id,
                new Title("The Perks of Being a Wallflower"),
                new Author("Stephen Chbosky"),
                Language.ENGLISH,
                AgeRating.PG_13));

        entityManager.flush();

        assertThat(jdbcTemplate.queryForObject("SELECT id FROM tt_books", UUID.class)).isEqualTo(id.getId());
        assertThat(jdbcTemplate.queryForObject("SELECT title FROM tt_books", String.class)).isEqualTo("The Perks of Being a Wallflower");
        assertThat(jdbcTemplate.queryForObject("SELECT author FROM tt_books", String.class)).isEqualTo("Stephen Chbosky");
        assertThat(jdbcTemplate.queryForObject("SELECT language FROM tt_books", Language.class)).isEqualTo(Language.ENGLISH);
        assertThat(jdbcTemplate.queryForObject("SELECT age_rating FROM tt_books", AgeRating.class)).isEqualTo(AgeRating.PG_13);
    }

    @Test
    void testFindAllPageable(){
        saveBooks(7);
        Sort sort = Sort.by(Sort.Direction.ASC, "title");

        assertThat(repository.findAll(PageRequest.of(0, 5, sort)))
                .hasSize(5)
                .extracting(book -> book.getTitle().getTitle()).containsExactly("Blue Period vol.0", "Blue Period vol.1",
                        "Blue Period vol.2", "Blue Period vol.3", "Blue Period vol.4");

        assertThat(repository.findAll(PageRequest.of(1, 5, sort)))
                .hasSize(2)
                .extracting(book -> book.getTitle().getTitle()).containsExactly("Blue Period vol.5", "Blue Period vol.6");

        assertThat(repository.findAll(PageRequest.of(2, 5, sort)))
                .isEmpty();
    }

    private void saveBooks(int amountOfBooks){
        for (int i = 0; i < amountOfBooks; i++){
            repository.save(new Book(repository.nextId(),
                    new Title(String.format("Blue Period vol.%d",i)),
                    new Author("Tsubasa Yamaguchi"),
                    Language.ENGLISH,
                    AgeRating.PG_13));
        }
    }

    @TestConfiguration
    static class TestConfig {
        @Bean
        public UniqueIdGenerator<UUID> uniqueIdGenerator() {
            return new InMemoryUniqueIdGenerator();
        }
    }

}