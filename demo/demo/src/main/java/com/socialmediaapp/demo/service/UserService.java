package com.socialmediaapp.demo.service;

import com.socialmediaapp.demo.model.Post;
import com.socialmediaapp.demo.model.User;
import com.socialmediaapp.demo.repository.UserJPARepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserJPARepository repository;

    private final static String USER_NOT_FOUND="user is not found!";

    public UserService(UserJPARepository repository) {this.repository = repository; }

    public List<User> findAllUsers() {return repository.findAll(); }

    public Optional<User> findUserByUserId(Long userId) {
        return repository.findById(userId);
    }

    public void createUser(String userName, String email, String firstName, String lastName, String bio) {
        if (userName == null || userName.isBlank() || email == null || email.isBlank()
        || firstName == null || firstName.isBlank() || lastName == null || lastName.isBlank()
        || bio == null || bio.isBlank()) {
         throw new RuntimeException();
        } else {
            repository.save(new User(userName, email, firstName, lastName, bio));
        }
    }

    public void deleteUser(Long userId) {
        User user = repository
                .findById(userId)
                .orElseThrow(()->new IllegalArgumentException(USER_NOT_FOUND));
        repository.delete(user);
    }

}
