package com.restapi.project.exception;

public class TodoNotFoundException extends Exception {
    public TodoNotFoundException(String message) {
        super(message);
    }
}
