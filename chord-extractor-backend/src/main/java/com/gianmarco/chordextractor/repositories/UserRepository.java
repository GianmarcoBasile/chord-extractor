package com.gianmarco.chordextractor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gianmarco.chordextractor.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

  public User findByUuid(String uuid);

}
