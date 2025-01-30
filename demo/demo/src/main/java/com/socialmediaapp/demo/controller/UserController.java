package com.socialmediaapp.demo.controller;

import com.socialmediaapp.demo.controller.response.UserResponse;
import com.socialmediaapp.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }
    
@GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(
                service.findAllUsers()
                .stream()
        .map(UserResponse::toResponse)
        .toList()
        );
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long userId){
        return ResponseEntity.ok(
                service.findUserByUserId(userId)
                        .map(UserResponse::toResponse)
                        .orElse(null)
        );
    }
}
