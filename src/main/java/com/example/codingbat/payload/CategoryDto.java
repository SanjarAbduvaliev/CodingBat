package com.example.codingbat.payload;

import com.example.codingbat.entity.Language;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Data
public class CategoryDto {
    @NotNull(message = "Field connot be empty")
    private String name;
    @NotNull(message = "Field connot be empty")
        private String discription;
    @NotNull(message = "Field connot be empty")
    private List<Integer> languages;
}
