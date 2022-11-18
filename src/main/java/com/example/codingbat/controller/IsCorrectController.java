package com.example.codingbat.controller;

import com.example.codingbat.entity.IsCorrect;
import com.example.codingbat.payload.ApiResponce;
import com.example.codingbat.payload.IsCorrectDto;
import com.example.codingbat.service.IsCorrectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/iscorrect")
public class IsCorrectController {
    @Autowired
    IsCorrectService isCorrectService;

    @PostMapping
    public HttpEntity<ApiResponce> add(@Valid @RequestBody IsCorrectDto isCorrectDto) {
        return ResponseEntity.ok(isCorrectService.add(isCorrectDto));
    }
    @GetMapping
    public HttpEntity<List<IsCorrect>> getAll(){
        return ResponseEntity.ok(isCorrectService.getAll());
    }
    @GetMapping("/iscoorectid/{id}")
    public HttpEntity<IsCorrect> getId(@PathVariable  Integer id){
       return ResponseEntity.ok(isCorrectService.getId(id));
    }
    @PutMapping("/edit/{id}")
    public HttpEntity<ApiResponce> edit(@Valid @RequestBody IsCorrectDto isCorrectDto,@PathVariable Integer id){
        return ResponseEntity.ok(isCorrectService.edit(isCorrectDto,id));
    }
    @DeleteMapping("/{id}")
    public HttpEntity<ApiResponce> delete(@PathVariable Integer id){
        return ResponseEntity.ok(isCorrectService.delete(id));
    }
}
