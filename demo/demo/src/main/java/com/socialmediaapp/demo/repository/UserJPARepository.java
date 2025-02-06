package com.socialmediaapp.demo.repository;

import com.socialmediaapp.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPARepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);
}
