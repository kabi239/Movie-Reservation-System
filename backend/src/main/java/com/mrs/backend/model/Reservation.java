package com.mrs.backend.model;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long reservationId;

    @ManyToOne
    @JoinColumn(name="schedule_id")
    private Schedules schedule;

    @ElementCollection
    @CollectionTable(name = "reserved_seats", joinColumns = @JoinColumn(name = "reservation_id"))
    @Column(name = "seat")
    private List<String> seats;
}
