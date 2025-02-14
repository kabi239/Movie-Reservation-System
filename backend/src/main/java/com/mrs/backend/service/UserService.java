package com.mrs.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mrs.backend.model.User;
import com.mrs.backend.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;  

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }


}
