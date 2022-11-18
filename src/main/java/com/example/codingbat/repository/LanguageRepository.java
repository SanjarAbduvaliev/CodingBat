package com.example.codingbat.repository;

import com.example.codingbat.entity.Language;
import com.example.codingbat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LanguageRepository extends JpaRepository<Language,Integer> {
    boolean existsByName(String name);
}
