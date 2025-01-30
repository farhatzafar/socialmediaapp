package com.socialmediaapp.demo.controller.response;

import com.socialmediaapp.demo.model.User;

public class UserResponse {

    String name;
    String email;
    String bio;

    public UserResponse() {
    }

    public UserResponse(String name, String email, String bio) {
        this.name = name;
        this.email = email;
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public static UserResponse toResponse(User user) {
        return new UserResponse(String.format("%s %s", user.getFirstName(), user.getLastName()),
                user.getEmail(), user.getBio());
    }
}
