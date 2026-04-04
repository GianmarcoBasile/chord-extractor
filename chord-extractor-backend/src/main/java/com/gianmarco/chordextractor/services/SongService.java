package com.gianmarco.chordextractor.services;

import org.springframework.stereotype.Service;

import com.gianmarco.chordextractor.models.Song;
import com.gianmarco.chordextractor.models.SongDTO;

@Service
public class SongService {
  public SongDTO convertToDTO(Song song) {
    SongDTO dto = null;
    if(song != null) {
      dto = new SongDTO(song.getUuid(), song.getTitle(), song.getDuration(), song.getBpm(), song.getUrl(), song.getGeneratedBy().getUuid());
    }
    return dto;
  }
}
