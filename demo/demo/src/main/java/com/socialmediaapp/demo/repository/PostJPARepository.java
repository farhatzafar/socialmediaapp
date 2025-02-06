package com.socialmediaapp.demo.repository;

import com.socialmediaapp.demo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostJPARepository extends JpaRepository<Post, Long> {

    List<Post> findByContentContainingIgnoreClass(String keyword);
}
