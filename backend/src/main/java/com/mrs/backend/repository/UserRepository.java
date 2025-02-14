package com.mrs.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrs.backend.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findById(Long id);

    void deleteById(Long id); 
}