package com.learning.spring_deep_dive.service;

import com.learning.spring_deep_dive.dto.UserDTO;
import com.learning.spring_deep_dive.entity.UserEntity;
import com.learning.spring_deep_dive.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map(UserDTO::new).toList();
    }

    public void insertUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity(userDTO);
        userRepository.save(userEntity);
    }

    public UserDTO updateUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity(userDTO);
        userRepository.save(userEntity);
        return userDTO;
    }

    public void deleteUser(Long id) {
        UserEntity user = userRepository.findById(id).get();
        userRepository.delete(user);
    }

    public UserDTO getUserById(Long id) {
        return new UserDTO(userRepository.findById(id).get());
    }
}
