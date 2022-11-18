package com.example.codingbat.controller;

import com.example.codingbat.entity.User;
import com.example.codingbat.payload.ApiResponce;
import com.example.codingbat.payload.UserDto;
import com.example.codingbat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/creataccount")
    public HttpEntity<ApiResponce> add(UserDto userDto){
        ApiResponce apiResponce = userService.addAser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponce);
    }
    @GetMapping("/getAll")
    public HttpEntity<List<User>> getAll(){
        List<User> allUser = userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }
    @GetMapping("/getId/{id}")
    public HttpEntity<User> getId(@PathVariable Integer id){
        return ResponseEntity.ok(userService.getUserId(id));
    }
    @PutMapping("/edituser/{id}")
    public HttpEntity<ApiResponce> edit(@Valid @RequestBody UserDto userDto,@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.RESET_CONTENT).body(userService.editUser(userDto,id));
    }
    @DeleteMapping("/deleteAccount/{userid}")
    public HttpEntity<ApiResponce> delete(@PathVariable Integer userid){

        ApiResponce apiResponce = userService.deleteUser(userid);
        return new HttpEntity<>(apiResponce);
    }
}
