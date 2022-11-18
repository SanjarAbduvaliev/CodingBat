package com.example.codingbat.payload;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ExampleDto {
    @NotNull(message = "Field connot be empty")
    private String text;
    @NotNull(message = "Field connot be empty")
    private Integer task_id;
}
