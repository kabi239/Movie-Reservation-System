package com.mrs.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrs.backend.model.Reservation;
import com.mrs.backend.model.Schedules;
import com.mrs.backend.payload.ReservationDTO;
import com.mrs.backend.payload.ScheduleDTO;
import com.mrs.backend.repository.ReservationsRepository;

import jakarta.transaction.Transactional;

@Service
public class ReservationService {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private ReservationsRepository reservationRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ReservationDTO> getAllReservations() {
        List<Reservation>reservation = reservationRepository.findAllReservation();
        List<ReservationDTO> reservationDTO = reservation.stream().map(reserv -> modelMapper.map(reserv, ReservationDTO.class)).toList();
        return reservationDTO;
    }

    public String generateReservations() {
       List<ScheduleDTO> schedules = scheduleService.getAllSchedules();
        List<Reservation> newReservations = new ArrayList<>();

        for (ScheduleDTO scheduleDTO : schedules) {
            Reservation reservation = modelMapper.map(scheduleDTO, Reservation.class);
            if (!reservationRepository.existsBySchedule(reservation.getSchedule())) {
                reservation.setSchedule(modelMapper.map(scheduleDTO, Schedules.class));
                reservation.setSeats(new ArrayList<>()); 
                newReservations.add(reservation);
            }
        }

        reservationRepository.saveAll(newReservations);

        return newReservations.size() + " new reservations created";
    }

    @Transactional
    public void addSeatsToReservation(Long schedule_id, List<String> seatIds) {
        Reservation reservation = reservationRepository.findBySchedule_ScheduleId(schedule_id)
        .orElseThrow(() -> new IllegalArgumentException("Reservation not found for given schedule id " + schedule_id));
        List<String> currentSeats = reservation.getSeats();
        currentSeats.addAll(seatIds);
        reservationRepository.save(reservation);
    }

    public List<String> getOccupiedSeats(Long schedule_id) {
        Reservation reservation = reservationRepository.findBySchedule_ScheduleId(schedule_id)
        .orElseThrow(() -> new IllegalArgumentException("Reservation not found for given schedule id " + schedule_id));
        return reservation.getSeats();

    }

    public List<ReservationDTO> getReservationByMovieId(Long movieId) {
        List<Reservation> reservations = reservationRepository.findBySchedule_movie_movieId(movieId);
        List<ReservationDTO> reservationDTO = reservations.stream().map(reserv -> modelMapper.map(reserv, ReservationDTO.class)).toList();
        return reservationDTO;
    }

}
