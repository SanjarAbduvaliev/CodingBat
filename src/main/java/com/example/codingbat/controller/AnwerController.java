package com.example.codingbat.controller;

import com.example.codingbat.payload.AnswerDto;
import com.example.codingbat.payload.ApiResponce;
import com.example.codingbat.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/answer")
public class AnwerController {
    @Autowired
    AnswerService answerService;
    @PostMapping("/youranswer/{id}")

    public HttpEntity<ApiResponce> add(@Valid @RequestBody AnswerDto answerDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(answerService.add(answerDto));
    }

}
