package com.example.codingbat.service;

import com.example.codingbat.entity.Answer;
import com.example.codingbat.entity.IsCorrect;
import com.example.codingbat.entity.Tasks;
import com.example.codingbat.entity.User;
import com.example.codingbat.payload.AnswerDto;
import com.example.codingbat.payload.ApiResponce;
import com.example.codingbat.repository.AnswerRepository;
import com.example.codingbat.repository.TaskRepository;
import com.example.codingbat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerService {
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    IsCorrect isCorrect;

    public ApiResponce add(AnswerDto answerDto){

        if (answerRepository.existsByUserId(answerDto.getUserId())) {


            Answer answer = new Answer();
            answer.setUserReturnText(answerDto.getUserReturnText());

            Optional<Tasks> optionalTasks = taskRepository.findById(answerDto.getTaskId());
            if (!optionalTasks.isPresent()) {
                return new ApiResponce("No such a task exists", false);
            }

            answer.setTasks(optionalTasks.get());
            if (isCorrect.getCorrectText().equals(answerDto.getUserReturnText())) {
                answer.setTest(true);
                answerRepository.save(answer);
                return new ApiResponce("Answer added", true);
            }
        }
        return new ApiResponce("User not found",false);
    }

}
