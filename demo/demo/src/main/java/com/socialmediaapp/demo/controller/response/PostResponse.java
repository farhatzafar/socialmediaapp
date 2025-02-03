package com.socialmediaapp.demo.controller.response;

import com.socialmediaapp.demo.model.Post;
import com.socialmediaapp.demo.model.User;

public class PostResponse {

    String content;
    UserResponse author;
    int likes;

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public UserResponse getAuthor() {
        return author;
    }

    public void setAuthor(UserResponse author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PostResponse(String content, UserResponse author, int likes) {
        this.content = content;
        this.author = author;
        this.likes = likes;
    }

    public static PostResponse toResponse(Post post) {
        return new PostResponse(post.getContent(),
                UserResponse.toResponse(post.getAuthor()),
                        post.getLikes().size());
    }
}
