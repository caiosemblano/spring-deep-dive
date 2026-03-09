package com.learning.spring_deep_dive.controller;

import com.learning.spring_deep_dive.dto.UserDTO;
import com.learning.spring_deep_dive.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> listAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public void insertUser(UserDTO userDTO) {
        userService.insertUser(userDTO);
    }

    @PutMapping
    public UserDTO updateUser(UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    //http/endereco/user/3 <- Parâmetro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }
}
