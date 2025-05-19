package com.project.shopapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.shopapp.dtos.UserDTO;
import com.project.shopapp.dtos.UserLoginDTO;
import com.project.shopapp.dtos.UserResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
@Validated
public class UsersController {

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserDTO userDTO) {
        // Placeholder for service call
        // In a real implementation, you would:
        // 1. Check if user with phone number/email already exists
        // 2. Hash the password
        // 3. Save the user to the database

        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody UserLoginDTO loginDTO) {
        // Placeholder for authentication service
        // In a real implementation, you would:
        // 1. Verify the credentials
        // 2. Generate JWT token
        // 3. Return token

        return ResponseEntity.ok("Authentication successful. Token: sample_token_12345");
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Integer id) {
        // Placeholder for service call
        UserResponse user = new UserResponse();
        return ResponseEntity.ok(user);
    }

    @GetMapping("/profile")
    public ResponseEntity<UserResponse> getUserProfile() {
        // Placeholder for service call
        // In a real implementation, you would extract user ID from JWT token

        UserResponse userResponse = new UserResponse();
        return ResponseEntity.ok(userResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable Integer id,
            @Valid @RequestBody UserDTO userDTO) {
        // Placeholder for service call

        UserResponse updatedUser = new UserResponse();
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        // Placeholder for service call
        // In a real implementation, you might want to deactivate users instead of
        // deleting

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/admin/users")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        // Placeholder for service call
        // In a real implementation, this should be restricted to admin users only

        List<UserResponse> users = new ArrayList<>();
        return ResponseEntity.ok(users);
    }
}