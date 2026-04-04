package com.gianmarco.chordextractor.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gianmarco.chordextractor.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

  public User findByUuid(String uuid);

}
