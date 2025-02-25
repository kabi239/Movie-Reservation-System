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

}
