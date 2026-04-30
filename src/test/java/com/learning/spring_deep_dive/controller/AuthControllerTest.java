package com.learning.spring_deep_dive.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.spring_deep_dive.dto.UserDTO;
import com.learning.spring_deep_dive.entity.UserEntity;
import com.learning.spring_deep_dive.entity.enums.UserStatus;
import com.learning.spring_deep_dive.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@org.springframework.test.context.ActiveProfiles("test")
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testNewUserRegistration() throws Exception {
        String login = "testuser_" + System.currentTimeMillis();
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Test User");
        userDTO.setEmail("test@test.com");
        userDTO.setLogin(login);
        userDTO.setPassword("password123");

        mockMvc.perform(post("/auth/newUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userDTO)))
                .andExpect(status().isOk());

        Optional<UserEntity> userOpt = userRepository.findByLogin(login);
        Assertions.assertTrue(userOpt.isPresent());
        Assertions.assertEquals(UserStatus.PENDANT, userOpt.get().getStatus());
    }
}
