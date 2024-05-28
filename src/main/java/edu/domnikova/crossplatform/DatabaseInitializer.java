package edu.domnikova.crossplatform;

import com.github.javafaker.Faker;
import edu.domnikova.crossplatform.myBooks.book.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("init-db")
public class DatabaseInitializer implements CommandLineRunner {
    private final Faker faker = new Faker();
    private final BookService bookService;

    public DatabaseInitializer(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) {
        for (int i = 0; i < 20; i++) {
            CreateBookParameters parameters = newRandomBookParameters();
            bookService.createBook(parameters);
        }
    }

    private CreateBookParameters newRandomBookParameters() {

        Title title = new Title(faker.book().title());
        Author author = new Author(faker.book().author());
        Language language = faker.options().option(Language.class);
        AgeRating ageRating = faker.options().option(AgeRating.class);

        return new CreateBookParameters(title, author, language,ageRating);
    }
}