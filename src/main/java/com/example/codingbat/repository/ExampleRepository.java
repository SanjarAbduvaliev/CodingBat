package com.example.codingbat.repository;

import com.example.codingbat.entity.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExampleRepository extends JpaRepository<Example,Integer> {
}
