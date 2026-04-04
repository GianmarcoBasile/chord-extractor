package com.gianmarco.chordextractor.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gianmarco.chordextractor.models.Song;
import com.gianmarco.chordextractor.models.User;
import com.gianmarco.chordextractor.models.UserDTO;
import com.gianmarco.chordextractor.repositories.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository repository;

  private UserDTO convertToDTO(User user) {
    UserDTO dto = null;
    if (user != null) {
      dto = new UserDTO();
      dto.setUuid(user.getUuid());
      dto.setUsername(user.getUsername());
      dto.setEmail(user.getEmail());
      List<String> songsTitle = null;
      if (user.getSongs().size() > 0) {
        songsTitle = new ArrayList<String>();
        for (Song song : user.getSongs()) {
          songsTitle.add(song.getTitle());
        }
      }
      dto.setSongs(songsTitle);
    }
    return dto;
  }

  public List<UserDTO> getAll() {
    List<User> users = repository.findAll();
    List<UserDTO> dtoList = null;
    if (users.size() != 0) {
      dtoList = new ArrayList<UserDTO>();
      for (User user : users) {
        dtoList.add(convertToDTO(user));
      }
    }
    return dtoList;
  }

  public UserDTO getByUuid(String uuid) {
    User user = repository.findByUuid(uuid);
    UserDTO dto = null;
    if (user != null) {
      dto = convertToDTO(user);
    }
    return dto;
  }
}
