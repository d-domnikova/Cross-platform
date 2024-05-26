package edu.domnikova.crossplatform.book;

import io.github.wimdeblauwe.jpearl.AbstractEntityId;

import java.util.UUID;

public class BookId extends AbstractEntityId<UUID> {

   /**
   * Default constructor for JPA
   */
   protected BookId() {
   }

   public BookId(UUID id) {
       super(id);
   }
}