package com.gianmarco.chordextractor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gianmarco.chordextractor.models.Song;

public interface SongRepository extends JpaRepository<Song, Long>{

}
