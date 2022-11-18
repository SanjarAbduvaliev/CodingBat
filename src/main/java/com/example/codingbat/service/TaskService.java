package com.example.codingbat.service;

import com.example.codingbat.entity.Category;
import com.example.codingbat.entity.Tasks;
import com.example.codingbat.payload.ApiResponce;
import com.example.codingbat.payload.TaskDto;
import com.example.codingbat.repository.CategoryRepository;
import com.example.codingbat.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    CategoryRepository categoryRepository;


    public ApiResponce addTask(TaskDto taskDto){
        Tasks tasks=new Tasks();
        tasks.setName(taskDto.getName());
        tasks.setSolution(taskDto.getSolution());
        tasks.setHint(taskDto.getHint());
        tasks.setText(taskDto.getText());
        tasks.setMethod(taskDto.getMethod());
        tasks.setHasStar(taskDto.isHasStrar());

        Optional<Category> optionalCategory = categoryRepository.findById(taskDto.getCategoryId());
        if (!optionalCategory.isPresent())
            return new ApiResponce("no such a category exists",false);
        tasks.setCategory(optionalCategory.get());
        taskRepository.save(tasks);
        return new ApiResponce("Saved task",true);
    }
    public List<Tasks> getAll(){
        return taskRepository.findAll();
    }
    public Tasks getId(Integer id){
        Optional<Tasks> optionalTasks = taskRepository.findById(id);
        return optionalTasks.orElse(null);
    }
    public ApiResponce edit(TaskDto taskDto,Integer id){
        Optional<Tasks> optionalTasks = taskRepository.findById(id);


        Tasks tasks = optionalTasks.get();
        tasks.setName(taskDto.getName());
        tasks.setSolution(taskDto.getSolution());
        tasks.setHint(taskDto.getHint());
        tasks.setText(taskDto.getText());
        tasks.setMethod(taskDto.getMethod());
        tasks.setHasStar(taskDto.isHasStrar());
        Optional<Category> optionalCategory = categoryRepository.findById(taskDto.getCategoryId());
        tasks.setCategory(optionalCategory.get());
        return new ApiResponce("Task edited!",true);

    }

    public ApiResponce delete(Integer id){
        taskRepository.deleteById(id);
        return new ApiResponce("Deleted",true);
    }
}
