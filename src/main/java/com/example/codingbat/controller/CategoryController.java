package com.example.codingbat.controller;

import com.example.codingbat.entity.Category;
import com.example.codingbat.payload.ApiResponce;
import com.example.codingbat.payload.CategoryDto;
import com.example.codingbat.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @PostMapping("/adding")
    public HttpEntity<ApiResponce> add(@Valid@RequestBody CategoryDto categoryDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.addCategory(categoryDto));
    }
    @GetMapping
    public HttpEntity<List<Category>> getAll(){
        return ResponseEntity.ok(categoryService.getAll());
    }
    @GetMapping("/getcategoryid/{id}")
    public HttpEntity<Category> getId(@PathVariable Integer id){
        return ResponseEntity.ok(categoryService.getId(id));
    }
    @PutMapping("/editcat/{id}")
    public HttpEntity<ApiResponce> edit(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer id){
        return ResponseEntity.ok(categoryService.edit(categoryDto,id));
    }
    @DeleteMapping("/delete/{id}")
    public HttpEntity<ApiResponce> delete(@PathVariable Integer id){
        return ResponseEntity.ok(categoryService.delete(id));
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
