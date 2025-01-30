package com.socialmediaapp.demo.service;

import com.socialmediaapp.demo.model.User;
import com.socialmediaapp.demo.repository.UserJPARepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserJPARepository repository;

    public UserService(UserJPARepository repository) {this.repository = repository; }

    public List<User> findAllUsers() {return repository.findAll(); }

    public Optional<User> findUserByUserId(Long userId) {
        return repository.findById(userId);
    }
}
