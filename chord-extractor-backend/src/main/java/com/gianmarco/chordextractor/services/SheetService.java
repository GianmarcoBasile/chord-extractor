package com.gianmarco.chordextractor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gianmarco.chordextractor.models.Sheet;
import com.gianmarco.chordextractor.models.SheetDTO;
import com.gianmarco.chordextractor.repositories.SheetRepository;

@Service
public class SheetService {
  @Autowired
  private SheetRepository repository;

  private SheetDTO convertToDTO(Sheet sheet) {
    SheetDTO dto = null;
    if (sheet != null) {
      dto = new SheetDTO(sheet.getUuid(), sheet.getTitle(), sheet.getChords());
    }
    return dto;
  }

  public SheetDTO getSheet(String uuid) {
    SheetDTO dto = null;
    if (!uuid.isBlank()) {
      Sheet sheet = repository.findByUuid(uuid);
      if (sheet != null) {
        dto = convertToDTO(sheet);
      }
    }
    return dto;
  }

  public boolean saveSheet(SheetDTO sheetDTO) throws IllegalArgumentException {
    if (sheetDTO == null || sheetDTO.getTitle() == null || sheetDTO.getUuid() == null || sheetDTO.getTitle().isBlank()
        || sheetDTO.getUuid().isBlank()) {
      throw new IllegalArgumentException();
    }

    Sheet sheet = new Sheet(sheetDTO.getUuid(), sheetDTO.getTitle(), sheetDTO.getChords());
    repository.save(sheet);
    return true;
  }
}
