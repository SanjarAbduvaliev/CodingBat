package com.example.codingbat.controller;

import com.example.codingbat.entity.Language;
import com.example.codingbat.payload.ApiResponce;
import com.example.codingbat.payload.LanguageDto;
import com.example.codingbat.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/language")
public class LanguageController {
    @Autowired
    LanguageService languageService;
    @PostMapping
    public HttpEntity<ApiResponce> add(@Valid @RequestBody LanguageDto languageDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(languageService.addLaguage(languageDto));
    }
    @GetMapping
    public HttpEntity<List<Language>> getAll(){
        return ResponseEntity.ok(languageService.getAllLangage());
    }
    @GetMapping("/getlanguageId/{id}")
    public HttpEntity<Language> getId(@PathVariable Integer id){
        return ResponseEntity.ok(languageService.getLanguageId(id));
    }
    @PutMapping("/langEdit/{languageId}")
    public HttpEntity<ApiResponce> edit(@Valid @RequestBody LanguageDto languageDto, @PathVariable Integer languageId){
        return ResponseEntity.status(HttpStatus.RESET_CONTENT).body(languageService.editLanguage(languageDto,languageId));
    }
    @DeleteMapping("/langdelete/{id}")
    public HttpEntity<ApiResponce> delete(@PathVariable Integer id){
        return ResponseEntity.ok(languageService.deleteLanguage(id));
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
