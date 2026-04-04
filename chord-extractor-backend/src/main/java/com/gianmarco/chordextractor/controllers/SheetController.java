package com.gianmarco.chordextractor.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gianmarco.chordextractor.models.SheetDTO;
import com.gianmarco.chordextractor.services.SheetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/sheets")
public class SheetController {
  @Autowired
  private SheetService service;

  @PostMapping
  public ResponseEntity<SheetDTO> saveSheet(@RequestBody SheetDTO sheet) {
    service.saveSheet(sheet);
    return ResponseEntity.ok(sheet);
  }

  @GetMapping("/{uuid}")
  public ResponseEntity<SheetDTO> getSheet(@PathVariable String uuid) {
    return ResponseEntity.ok(service.getSheet(uuid));
  }

}
