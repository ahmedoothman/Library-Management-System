package com.othman.lms.controller;

import com.othman.lms.dto.LoginDTO;
import com.othman.lms.dto.UserRegistrationDTO;
import com.othman.lms.dto.ErrorResponse;
import com.othman.lms.dto.SuccessResponse;
import com.othman.lms.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRegistrationDTO userDTO) {
        boolean isRegistered = userService.registerUser(userDTO);
        if (isRegistered) {
            SuccessResponse<String> successResponse = new SuccessResponse<>("User registered successfully", null);
            return ResponseEntity.ok(successResponse);
        } else {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "User registration failed or username already exists");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody LoginDTO loginDTO) {
        String token = userService.loginUser(loginDTO);
        if (token != null) {
            SuccessResponse<String> successResponse = new SuccessResponse<>("Login successful", token);
            return ResponseEntity.ok(successResponse);
        } else {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.UNAUTHORIZED.value(), "Invalid username or password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }
}
