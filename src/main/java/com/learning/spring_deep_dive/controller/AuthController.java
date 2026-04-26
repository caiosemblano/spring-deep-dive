package com.learning.spring_deep_dive.controller;

import com.learning.spring_deep_dive.dto.AuthenticationDTO;
import com.learning.spring_deep_dive.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDTO authDTO) {
        return ResponseEntity.ok(authService.login(authDTO));
    }


}
