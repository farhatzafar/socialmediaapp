package com.socialmediaapp.demo.controller;

import com.socialmediaapp.demo.controller.request.PostRequest;
import com.socialmediaapp.demo.controller.response.PostResponse;
import com.socialmediaapp.demo.controller.response.UserResponse;
import com.socialmediaapp.demo.service.PostService;
import com.socialmediaapp.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody PostRequest post) {
        service.createPost(post.getContent(), post.getAuthorId());
    }

    @PutMapping("{postId}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePost(@PathVariable Long postId, @RequestBody PostRequest post) {
        service.updatePost(post.getContent(), post.getAuthorId(), postId);
    }

    @DeleteMapping("{postId}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePost(@PathVariable Long postId) {
        service.deletePost(postId);
    }

}
