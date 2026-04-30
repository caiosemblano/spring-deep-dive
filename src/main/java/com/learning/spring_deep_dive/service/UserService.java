package com.learning.spring_deep_dive.service;

import com.learning.spring_deep_dive.dto.UserDTO;
import com.learning.spring_deep_dive.entity.UserEntity;
import com.learning.spring_deep_dive.entity.enums.UserStatus;
import com.learning.spring_deep_dive.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import com.learning.spring_deep_dive.entity.UserVerificationEntity;
import com.learning.spring_deep_dive.repository.UserVerificationRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserVerificationRepository userVerificationRepository;

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
        userEntity.setStatus(userDTO.getStatus());
        userRepository.save(userEntity);
    }

    public void insertNewUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity(userDTO);
        userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userEntity.setStatus(UserStatus.PENDANT);
        userEntity = userRepository.save(userEntity);

        UUID token = UUID.randomUUID();
        Instant expirationTime = Instant.now().plus(15, ChronoUnit.MINUTES);
        UserVerificationEntity verificationEntity = new UserVerificationEntity(token, userEntity, expirationTime);
        userVerificationRepository.save(verificationEntity);

        String subject = "Account Verification";
        String text = "Please verify your account using this token: " + token.toString() + "\nThis token will expire in 15 minutes.";
        
        emailService.sendEmail(userDTO.getEmail(), subject, text);
    }

    public UserDTO updateUser(UserDTO userDTO) {
        UserEntity userEntity = userRepository.findById(userDTO.getId())
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + userDTO.getId()));
        
        userEntity.setName(userDTO.getName());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setLogin(userDTO.getLogin());
        if (userDTO.getPassword() != null && !userDTO.getPassword().isEmpty()) {
            userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        }
        userEntity.setStatus(userDTO.getStatus());
        
        userRepository.save(userEntity);
        return new UserDTO(userEntity);
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
