package com.example.codingbat.controller;

import com.example.codingbat.entity.Tasks;
import com.example.codingbat.payload.ApiResponce;
import com.example.codingbat.payload.TaskDto;
import com.example.codingbat.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    TaskService taskService;
    @PostMapping
    public HttpEntity<ApiResponce> add(@Valid @RequestBody TaskDto taskDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.addTask(taskDto));
    }
    @GetMapping
    public HttpEntity<List<Tasks>> getAll(){
        return ResponseEntity.ok(taskService.getAll());
    }
    @GetMapping("/getid/{id}")
    public HttpEntity<Tasks> getId(@PathVariable Integer id){
        return ResponseEntity.ok(taskService.getId(id));
    }
    @PutMapping("/editing/{id}")
    public HttpEntity<ApiResponce> edit(@Valid@RequestBody TaskDto taskDto,@PathVariable Integer  id){
        return ResponseEntity.ok(taskService.edit(taskDto,id));
    }
    @DeleteMapping("/delete/{id}")
    public HttpEntity<ApiResponce> delete(@PathVariable Integer id){
        return ResponseEntity.ok(taskService.delete(id));
    }
}
