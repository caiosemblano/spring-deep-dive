package com.learning.spring_deep_dive.controller;

import com.learning.spring_deep_dive.dto.AuthenticationDTO;
import com.learning.spring_deep_dive.dto.UserDTO;
import com.learning.spring_deep_dive.service.AuthService;
import com.learning.spring_deep_dive.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    AuthService authService;

    @Autowired
    UserService userService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDTO authDTO) {
        return ResponseEntity.ok(authService.login(authDTO));
    }

    @PostMapping(value = "/newUser")
    public void newUser(@RequestBody UserDTO userDTO) {
        userService.insertNewUser(userDTO);
    }

}
