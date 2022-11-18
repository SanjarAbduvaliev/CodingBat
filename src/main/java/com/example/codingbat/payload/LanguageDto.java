package com.example.codingbat.payload;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LanguageDto {
    @NotNull(message = "Field connot be empty")
    private String name;
}
