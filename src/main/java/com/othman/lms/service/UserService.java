package com.othman.lms.service;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.othman.lms.dto.LoginDTO;
import com.othman.lms.dto.UserRegistrationDTO;
import com.othman.lms.entity.User;
import com.othman.lms.repository.UserRepository;
import com.othman.lms.security.JwtUtil;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;


    public boolean registerUser(UserRegistrationDTO userDTO) {
        if (userRepository.existsByUsername(userDTO.getUsername())) {
            return false; // Username already exists
        }

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword())); // Encrypt the password
        user.setRole(userDTO.getRole()); // Set role

        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
        // for later
            return false;
        }
    }
        public String loginUser(LoginDTO loginDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return jwtUtil.generateToken(userDetails.getUsername());
        } catch (Exception e) {
            // for later
            return null;
        }
    }
}
