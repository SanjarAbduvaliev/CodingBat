package com.example.codingbat.repository;

import com.example.codingbat.entity.Category;
import com.example.codingbat.entity.Language;
import com.example.codingbat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
boolean existsByName(String name);
boolean existsByNameAndId(String name, Integer id);
}
