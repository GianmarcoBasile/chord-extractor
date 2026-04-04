package com.gianmarco.chordextractor.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.gianmarco.chordextractor.models.Sheet;

public interface SheetRepository extends MongoRepository<Sheet, ObjectId> {
  public Sheet findByUuid(String uuid);
}
