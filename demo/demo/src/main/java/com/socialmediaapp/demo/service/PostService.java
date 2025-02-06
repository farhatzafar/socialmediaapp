package com.socialmediaapp.demo.service;

import com.socialmediaapp.demo.model.Post;
import com.socialmediaapp.demo.model.User;
import com.socialmediaapp.demo.repository.PostJPARepository;
import com.socialmediaapp.demo.repository.UserJPARepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final static String USER_NOT_FOUND="user is not found!";
    private final static String POST_NOT_FOUND="post is not found!";
    private final PostJPARepository repository;
    private final UserJPARepository userRepository;

    public PostService(PostJPARepository repository, UserJPARepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public List<Post> findAllPosts() {
        return repository.findAll();
    }

    public Optional<Post> findPostById(Long postId) {
        return repository.findById(postId);
    }

    public void createPost(String content, Long authorId) {
        User author = userRepository
                .findById(authorId)
                .orElseThrow(
                        ()->new IllegalArgumentException(USER_NOT_FOUND)
                );
        repository.save(new Post(content, author));
    }

    public void deletePost(Long postId) {
        Post post = repository
                .findById(postId)
                .orElseThrow(()->new IllegalArgumentException(POST_NOT_FOUND));
        repository.delete(post);
    }

    public void updatePost(String content, Long authorId, Long postId) {
        Post post = repository.findById(postId)
                .orElseThrow(()->new IllegalArgumentException(POST_NOT_FOUND));
        if (authorId.equals(post.getAuthor().getUserId())) {
            post.setContent(content);
            repository.save(post);
        } else {
            throw new IllegalArgumentException(POST_NOT_FOUND);
        }
    }

}
