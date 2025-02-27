package com.mrs.backend.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrs.backend.payload.ReservationDTO;
import com.mrs.backend.service.ReservationService;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/user")
public class UserReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservations")
    public ResponseEntity<List<ReservationDTO>> getReservations() {
        List<ReservationDTO> reservationDTO = reservationService.getAllReservations();
        return new ResponseEntity<>(reservationDTO, HttpStatus.OK);
    }

    @PostMapping("/reservations/{schedule_id}/add-seats")
    public ResponseEntity<Map<String,String>> addSeatsToReservation(
        @PathVariable Long schedule_id, 
        @RequestBody List<String> seatIds) {
        Map<String,String> response = new HashMap<>();
        try {
            reservationService.addSeatsToReservation(schedule_id, seatIds);
            response.put("message", "Seats added successfully to the reservation.");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        catch (Exception e) {
            response.put("error", "An error occurred while adding seats to the reservation.");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/reservations/{schedule_id}/occupied-seats")
        public ResponseEntity<List<String>> getOccupiedSeats(@PathVariable Long schedule_id) {
            List<String> occupiedSeats = reservationService.getOccupiedSeats(schedule_id);
            return new ResponseEntity<>(occupiedSeats, HttpStatus.OK);
        }
    
        @GetMapping("/reservations/movie/")
        public List<ReservationDTO> getReservationByMovieId(@RequestParam Long movieId) {
            return reservationService.getReservationByMovieId(movieId);
        }
    

}
