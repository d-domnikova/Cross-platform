package edu.domnikova.crossplatform.myBooks.book;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class AuthorAttributeConverter implements AttributeConverter<Author, String> {
    @Override
    public String convertToDatabaseColumn(Author attribute) {
        return attribute.asString();
    }
    @Override
    public Author convertToEntityAttribute(String dbData) {
        return new Author(dbData);
    }
}