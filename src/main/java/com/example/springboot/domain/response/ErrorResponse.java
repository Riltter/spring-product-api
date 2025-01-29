package com.example.springboot.domain.response;

import java.util.List;
import java.util.Map;

public class ErrorResponse {
    private String message;
    private int status;
    private List<Map<String, String>> errors;

    public ErrorResponse(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public ErrorResponse(String message, int status, List<Map<String, String>> errors) {
        this.message = message;
        this.status = status;
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Map<String, String>> getErrors() {
        return errors;
    }

    public void setErrors(List<Map<String, String>> errors) {
        this.errors = errors;
    }
}
