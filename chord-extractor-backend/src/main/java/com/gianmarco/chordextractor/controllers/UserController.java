package com.gianmarco.chordextractor.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gianmarco.chordextractor.models.UserDTO;
import com.gianmarco.chordextractor.services.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserService service;

  @GetMapping
  public List<UserDTO> getUsers() {
    return service.getAll();
  }
  
    @GetMapping("/{user_uuid}")
  public UserDTO getUser(@PathVariable String user_uuid) {
    return service.getByUuid(user_uuid);
  }
  
}
