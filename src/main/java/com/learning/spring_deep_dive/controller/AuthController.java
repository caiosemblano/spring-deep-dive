package com.learning.spring_deep_dive.controller;

import com.learning.spring_deep_dive.dto.AuthenticationDTO;
import com.learning.spring_deep_dive.dto.UserDTO;
import com.learning.spring_deep_dive.service.AuthService;
import com.learning.spring_deep_dive.service.UserService;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    private final UserService userService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDTO authDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(authService.login(authDTO));
    }

    @PostMapping(value = "/newUser")
    public ResponseEntity<?> newUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.insertNewUser(userDTO));
    }

}
