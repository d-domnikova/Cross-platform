package edu.domnikova.crossplatform.myBooks;

import edu.domnikova.crossplatform.myBooks.book.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@NotExistingBook(groups = BookValidationGroupTwo.class)
public class CreateBookFromData {
    @NotBlank
    @Size(min = 3, max = 200, groups = BookValidationGroupOne.class)
    private String title;
    @NotBlank
    @Size(min = 3, max = 200, groups = BookValidationGroupOne.class)
    private String author;
    @NotNull
    private Language language;
    @NotNull
    private AgeRating ageRating;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public AgeRating getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(AgeRating ageRating) {
        this.ageRating = ageRating;
    }

    public CreateBookParameters bookParameters(){
        return new CreateBookParameters(
                new Title(title),
                new Author(author),
                language,
                ageRating);
    }
}