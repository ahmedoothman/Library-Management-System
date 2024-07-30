package com.othman.lms.dto;

import java.util.Map;

import lombok.Data;

@Data
public class ErrorResponse {
    private int status;
    private String message;
    private Map details;
    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

}
