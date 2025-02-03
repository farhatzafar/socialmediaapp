package com.socialmediaapp.demo.repository;

import com.socialmediaapp.demo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJPARepository extends JpaRepository<Post, Long> {


}
