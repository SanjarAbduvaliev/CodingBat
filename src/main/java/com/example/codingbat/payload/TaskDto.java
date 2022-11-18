package com.example.codingbat.payload;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TaskDto {
    @NotNull(message = "Field connot be empty")
    private String name;
    @NotNull(message = "Field connot be empty")
    private String text;
    @NotNull(message = "Field connot be empty")
    private String solution;
    @NotNull(message = "Field connot be empty")
    private String hint;
    @NotNull(message = "Field connot be empty")
    private String method;
    @NotNull(message = "Field connot be empty")
    private boolean hasStrar;
    @NotNull(message = "Field connot be empty")
    private Integer categoryId;
}
