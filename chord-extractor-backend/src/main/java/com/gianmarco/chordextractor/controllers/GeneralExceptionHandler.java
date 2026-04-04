package com.gianmarco.chordextractor.controllers;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler {
  @ExceptionHandler(OptimisticLockingFailureException.class)
  public ResponseEntity<String> handleOptimisticLock(OptimisticLockingFailureException e) {
    return ResponseEntity.status(409).body("Conflict detected");
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException e) {
    return ResponseEntity.badRequest().body(e.getMessage());
  }
}
