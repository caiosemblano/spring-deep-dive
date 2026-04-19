package com.learning.spring_deep_dive.service;

import com.learning.spring_deep_dive.dto.AuthenticationDTO;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private AuthenticationManager authenticationManager;


    public AccessDTO login(AuthenticationDTO authDTO) {
        UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(
                authDTO.getUsername(), authDTO.getPassword());
        Authentication authentication = authenticationManager.authenticate(userAuth);

        UserDetailsImpl userDetails = (UserDetailsImpl)authentication.getPrincipal();
    }
}
