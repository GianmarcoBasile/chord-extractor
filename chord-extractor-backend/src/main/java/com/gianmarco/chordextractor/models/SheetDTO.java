package com.gianmarco.chordextractor.models;

import java.util.List;

public class SheetDTO {
  private String uuid;
  private String title;
  private List<ChordChange> chords;

  public SheetDTO() {
  }

  public SheetDTO(String uuid, String title, List<ChordChange> chords) {
    this.uuid = uuid;
    this.title = title;
    this.chords = chords;
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
}
