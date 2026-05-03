package com.learning.spring_deep_dive.exception;

// Esta é a sua exceção customizada de negócio
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
