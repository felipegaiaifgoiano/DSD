package com.example.errorhandling;

class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
