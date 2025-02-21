package com.mrs.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrs.backend.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
