package com.example.codingbat.repository;

import com.example.codingbat.entity.Tasks;
import com.example.codingbat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Tasks,Integer> {

}
