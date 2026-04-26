package com.learning.spring_deep_dive.dto;

public class AccessDTO {
    private String token;

    // TODO: implementar retornar usuário e liberações (authorities)


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public AccessDTO(String token) {
        super();
        this.token = token;
    }
}
