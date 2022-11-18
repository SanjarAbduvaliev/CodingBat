package com.example.codingbat.repository;

import com.example.codingbat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByEmail(String email);


    /*
    select * from user where email='user.emal' and id<>user.id
     */
    boolean existsByEmailAndIdNot(String email, Integer id);
}
