package com.mrs.backend.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrs.backend.exceptions.ResourceNotFoundException;
import com.mrs.backend.model.User;
import com.mrs.backend.payload.UserDTO;
import com.mrs.backend.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;  

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO createUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        User createdUser = userRepository.save(user);
        return modelMapper.map(createdUser, UserDTO.class);
    }
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTO =users.stream().map(user -> 
        modelMapper.map(user, UserDTO.class)).toList();
        return userDTO;
    }
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "userId", id));
        return modelMapper.map(user, UserDTO.class);
    }
    public void deleteUserById(Long id) {
        userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "userId", id));
        userRepository.deleteById(id);
    }


}
