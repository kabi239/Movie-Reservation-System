package com.mrs.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mrs.backend.model.Reservation;
import com.mrs.backend.model.Schedules;

public interface ReservationsRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT r FROM Reservation r")
    List<Reservation> findAllReservation();

    boolean existsBySchedule(Schedules schedule);



}
