package com.learning.spring_deep_dive.service;

import com.learning.spring_deep_dive.dto.AccessDTO;
import com.learning.spring_deep_dive.dto.AuthenticationDTO;
import com.learning.spring_deep_dive.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;



    public AccessDTO login(AuthenticationDTO authDTO) {
        try {
            // Cria mecanismo essencial para o Spring
            UsernamePasswordAuthenticationToken userAuth =
                    new UsernamePasswordAuthenticationToken(
                            authDTO.getUsername(),
                            authDTO.getPassword());

            //prepara mecanismo para autenticação
            Authentication authentication = authenticationManager.authenticate(userAuth);

            UserDetailsImpl userAuthenticate = (UserDetailsImpl) authentication.getPrincipal();

            String token = jwtUtils.generateTokenFromUserDetailsImpl(userAuthenticate);

            return new AccessDTO(token);

        } catch (BadCredentialsException e) {
            //TODO: login ou senha invalido
        }

        return new AccessDTO("Acesso negado");
    }
}
