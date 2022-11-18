package com.example.codingbat.service;

import com.example.codingbat.entity.IsCorrect;
import com.example.codingbat.entity.Tasks;
import com.example.codingbat.payload.ApiResponce;
import com.example.codingbat.payload.IsCorrectDto;
import com.example.codingbat.repository.IsCorrectRepository;
import com.example.codingbat.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class IsCorrectService {
    @Autowired
    IsCorrectRepository isCorrectRepository;
    @Autowired
    TaskRepository taskRepository;

    public ApiResponce add(IsCorrectDto isCorrectDto){
        IsCorrect isCorrect=new IsCorrect();
        isCorrect.setCorrectText(isCorrectDto.getCorrectText());
        Optional<Tasks> optionalTasks = taskRepository.findById(isCorrectDto.getTaskId());
        if (!optionalTasks.isPresent()){
            return new ApiResponce("no such task exists",false);
        }
        isCorrect.setTasks(optionalTasks.get());
        isCorrectRepository.save(isCorrect);
        return new ApiResponce("Correct saved",true);

    }

    public List<IsCorrect> getAll(){
        return isCorrectRepository.findAll();
    }

    public IsCorrect getId(Integer id){
        Optional<IsCorrect> byId = isCorrectRepository.findById(id);
        return byId.orElse(null);
    }
    public ApiResponce edit(IsCorrectDto isCorrectDto, Integer id){
        Optional<IsCorrect> optionalIsCorrect = isCorrectRepository.findById(id);
        Optional<Tasks> tasksOptional = taskRepository.findById(isCorrectDto.getTaskId());
        if (!optionalIsCorrect.isPresent()){
            return new ApiResponce("No such currect exists",false);
        }
        if (!tasksOptional.isPresent()){
            return new ApiResponce("No such task exists",false);
        }
        IsCorrect isCorrect = optionalIsCorrect.get();
        isCorrect.setCorrectText(isCorrectDto.getCorrectText());
        isCorrect.setTasks(tasksOptional.get());
        return new ApiResponce("Edited",true);
    }
    public ApiResponce delete(Integer id){
        isCorrectRepository.deleteById(id);
        return new ApiResponce("Deleted",true);
    }
}
