package com.othman.lms.controller;

import com.othman.lms.dto.PatronDTO;
import com.othman.lms.service.PatronService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/patrons")
@RequiredArgsConstructor
public class PatronController {
    private final PatronService patronService;

    @GetMapping
    public ResponseEntity<List<PatronDTO>> getAllPatrons() {
        List<PatronDTO> patrons = patronService.findAll();
        return new ResponseEntity<>(patrons, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatronDTO> getPatronById(@PathVariable Long id) {
            PatronDTO patron = patronService.findById(id);
            return new ResponseEntity<>(patron, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PatronDTO> addPatron(@Valid @RequestBody PatronDTO patronDTO) {
        PatronDTO newPatron = patronService.save(patronDTO);
        return new ResponseEntity<>(newPatron, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatronDTO> updatePatron(@PathVariable Long id,@Valid @RequestBody PatronDTO patronDTO) {
            PatronDTO updatedPatron = patronService.update(id, patronDTO);
            return new ResponseEntity<>(updatedPatron, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatron(@PathVariable Long id) {
        patronService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
