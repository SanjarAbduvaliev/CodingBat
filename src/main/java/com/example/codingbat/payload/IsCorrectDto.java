package com.example.codingbat.payload;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class IsCorrectDto {
    @NotNull(message = "Field connot be empty")
    private String correctText;
    @NotNull(message = "Field connot be empty")
    private Integer taskId;
}
