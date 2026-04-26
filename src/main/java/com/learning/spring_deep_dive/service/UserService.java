package com.learning.spring_deep_dive.service;

import com.learning.spring_deep_dive.dto.UserDTO;
import com.learning.spring_deep_dive.entity.UserEntity;
import com.learning.spring_deep_dive.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<UserDTO> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map(UserDTO::new).toList();
    }
    
    public void insertUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDTO.getName());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setLogin(userDTO.getLogin());
        userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userRepository.save(userEntity);
    }

    public ResponseEntity<UserDTO> updateUser(ResponseEntity<UserDTO> userDTO) {
        UserEntity userEntity = new UserEntity(userDTO.getBody());
        userRepository.save(userEntity);
        return userDTO;
    }

    public void deleteUser(Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + id));
        userRepository.delete(user);
    }

    public UserDTO getUserById(Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + id));
        return new UserDTO(user);
    }
}
