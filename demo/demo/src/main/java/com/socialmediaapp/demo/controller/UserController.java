package com.socialmediaapp.demo.controller;

import com.socialmediaapp.demo.controller.request.PostRequest;
import com.socialmediaapp.demo.controller.request.UserRequest;
import com.socialmediaapp.demo.controller.response.UserResponse;
import com.socialmediaapp.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserRequest user) {
        service.createUser(user.getUserName(), user.getEmail(), user.getFirstName(),
                user.getLastName(), user.getBio());
    }
}
