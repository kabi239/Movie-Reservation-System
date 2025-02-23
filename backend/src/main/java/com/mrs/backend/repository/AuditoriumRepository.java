package com.mrs.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrs.backend.model.Auditorium;

public interface AuditoriumRepository extends JpaRepository<Auditorium, Long> {
    
} 