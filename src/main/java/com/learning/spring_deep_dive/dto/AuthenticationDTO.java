package com.learning.spring_deep_dive.dto;

import lombok.Data;

@Data
public class AuthenticationDTO {
    private String username;
    private String password;
}
