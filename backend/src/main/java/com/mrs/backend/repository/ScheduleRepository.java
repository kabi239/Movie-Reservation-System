package com.mrs.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrs.backend.model.Schedules;

public interface ScheduleRepository extends JpaRepository<Schedules, Long> {
    
} 