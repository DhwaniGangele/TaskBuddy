package com.example.taskbuddy.exception;

// Exception Handling: Custom unchecked exception for clarity
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}

