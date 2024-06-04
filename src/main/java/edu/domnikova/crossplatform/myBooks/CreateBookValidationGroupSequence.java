package edu.domnikova.crossplatform.myBooks;

import jakarta.validation.GroupSequence;
import jakarta.validation.groups.Default;

@GroupSequence({Default.class, BookValidationGroupOne.class, BookValidationGroupTwo.class})
public interface CreateBookValidationGroupSequence {

}