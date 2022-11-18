package com.example.codingbat.payload;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserDto {
    @NotNull(message = "Field connot be empty")
    private String email;
    @NotNull(message = "Field connot be empty")
    private String password;
}
