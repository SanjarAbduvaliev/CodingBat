package com.example.codingbat.service;

import com.example.codingbat.entity.User;
import com.example.codingbat.payload.ApiResponce;
import com.example.codingbat.payload.UserDto;
import com.example.codingbat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ApiResponce addAser(UserDto userDto){
        if (userRepository.existsByEmail(userDto.getEmail())){
            return new ApiResponce("Such a user email exists",false);
        }
        User user=new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        userRepository.save(user);
        return new ApiResponce("Success was registred",true);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public User getUserId(Integer id){
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseGet(User::new);

    }
    public ApiResponce editUser(UserDto userDto,Integer id){
        boolean existsByEmailAndIdNot = userRepository.existsByEmailAndIdNot(userDto.getEmail(), id);
        if (existsByEmailAndIdNot){
            return new ApiResponce("Such a user email exists",false);
        }
        Optional<User> optionalUser = userRepository.findById(id);

        if (!optionalUser.isPresent()){
            return new ApiResponce("Not found",false);
        }
        User user = optionalUser.get();
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        userRepository.save(user);
        return new ApiResponce("Successful edited",true);
    }

    public ApiResponce deleteUser(Integer id){
        userRepository.deleteById(id);
        return new ApiResponce("Account deleted",true);
    }


}
