package edu.domnikova.crossplatform.myBooks.book;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TitleAttributeConverter implements AttributeConverter<Title, String> {
    @Override
    public String convertToDatabaseColumn(Title attribute) {
        return attribute.asString();
    }
    @Override
    public Title convertToEntityAttribute(String dbData) {
        return new Title(dbData);
    }
}