package com.mrs.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrs.backend.payload.AuditoriumDTO;
import com.mrs.backend.service.AuditoriumService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/admin")
public class AuditoriumController {

    @Autowired
    private AuditoriumService auditoriumService;

    @PostMapping("/auditorium")
    public ResponseEntity<AuditoriumDTO> createAuditorium(@Valid @RequestBody AuditoriumDTO auditoriumDTO) {
        AuditoriumDTO createdAuditorium = auditoriumService.createAuditorium(auditoriumDTO);
        return new ResponseEntity<>(createdAuditorium, HttpStatus.CREATED);
    }

    @GetMapping("/auditoriums")
    public ResponseEntity<List<AuditoriumDTO>> getAllAuditorium() {
        List<AuditoriumDTO> allAuditorium = auditoriumService.getAllAuditorium();
        return new ResponseEntity<>(allAuditorium, HttpStatus.OK);
    }

    @GetMapping("/auditorium/{id}")
    public ResponseEntity<AuditoriumDTO> getAuditoriumById(@PathVariable Long id) {
        AuditoriumDTO auditorium = auditoriumService.getAuditoriumById(id);
        return new ResponseEntity<>(auditorium, HttpStatus.OK);
    }

    @DeleteMapping("/auditorium/{id}")
    public ResponseEntity<String> deleteAuditorium(@PathVariable Long id) {
        auditoriumService.deleteAuditorium(id);
        return new ResponseEntity<>("Auditorium deleted successfully", HttpStatus.OK);
    }
    
    
    

}
