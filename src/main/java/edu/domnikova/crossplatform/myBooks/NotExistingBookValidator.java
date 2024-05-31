package edu.domnikova.crossplatform.myBooks;

import edu.domnikova.crossplatform.myBooks.book.BookService;
import edu.domnikova.crossplatform.myBooks.book.Title;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class NotExistingBookValidator implements ConstraintValidator<NotExistingBook, CreateBookFromData> {

    private final BookService service;

    @Autowired
    public NotExistingBookValidator(BookService service) {
        this.service = service;
    }

    @Override
    public void initialize(NotExistingBook constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(CreateBookFromData formData, ConstraintValidatorContext context) {
        if (service.BookWithTitleExist(new Title(formData.getTitle()))) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("{BookAlreadyExisting}")
                    .addPropertyNode("title").addConstraintViolation();
            return false;
        }
        return true;
    }
}
