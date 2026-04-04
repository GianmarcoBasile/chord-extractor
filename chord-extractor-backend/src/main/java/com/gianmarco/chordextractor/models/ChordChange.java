package com.gianmarco.chordextractor.models;

public class ChordChange {
  private String chord;
  private double timestamp;

  public ChordChange() {}

  public ChordChange(String chord, double timestamp) {
    this.chord = chord;
    this.timestamp = timestamp;
  }

  public String getChord() {
    return chord;
  }

  public void setChord(String chord) {
    this.chord = chord;
  }

  public double getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(double timestamp) {
    this.timestamp = timestamp;
  }

  @Override
  public String toString() {
    return "ChordChange [chord=" + chord + ", timestamp=" + timestamp + "]";
  }
  
}
