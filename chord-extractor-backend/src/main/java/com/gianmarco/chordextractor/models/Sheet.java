package com.gianmarco.chordextractor.models;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document(collection = "chords")
public class Sheet {
  @Id
  private ObjectId id;

  @Indexed(unique = true)
  private String uuid;

  @Indexed(unique = true)
  private String title;

  private List<ChordChange> chords;

  public Sheet() {
  }

  public Sheet(String uuid, String title, List<ChordChange> chords) {
    this.uuid = uuid;
    this.title = title;
    this.chords = chords;
  }

  public ObjectId getId() {
    return id;
  }

  public void setId(ObjectId id) {
    this.id = id;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public List<ChordChange> getChords() {
    return chords;
  }

  public void setChords(List<ChordChange> chords) {
    this.chords = chords;
  }

  @Override
  public String toString() {
    return "Sheet [id=" + id + ", uuid=" + uuid + ", title=" + title + ", chords=" + chords + "]";
  }

}
