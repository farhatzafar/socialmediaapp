package com.socialmediaapp.demo.controller;

import com.socialmediaapp.demo.controller.response.PostResponse;
import com.socialmediaapp.demo.controller.response.UserResponse;
import com.socialmediaapp.demo.service.PostService;
import com.socialmediaapp.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/posts")
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PostResponse>> getAllPosts() {
        return ResponseEntity.ok(
                service.findAllPosts()
                        .stream()
                        .map(PostResponse::toResponse)
                        .toList()
        );
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostResponse> getPost(@PathVariable Long postId) {
        return ResponseEntity.ok(
                service.findPostById(postId)
                        .map(PostResponse::toResponse)
                        .orElse(null)
        );
    }

}
