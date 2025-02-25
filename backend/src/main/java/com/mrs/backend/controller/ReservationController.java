package com.mrs.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrs.backend.payload.ReservationDTO;
import com.mrs.backend.service.ReservationService;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/admin")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservations")
    public ResponseEntity<List<ReservationDTO>> getReservations() {
        List<ReservationDTO> reservationDTO = reservationService.getAllReservations();
        return new ResponseEntity<>(reservationDTO, HttpStatus.OK);
    }

    @PostMapping("reservation/generate")
    public ResponseEntity<String> generateReservations() {
        String message = reservationService.generateReservations();
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    
}
