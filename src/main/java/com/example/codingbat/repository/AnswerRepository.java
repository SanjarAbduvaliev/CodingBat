package com.example.codingbat.repository;

import com.example.codingbat.entity.Answer;
import com.example.codingbat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer,Integer> {
    boolean existsByUserId(Integer user_id);
}
