package com.example.codingbat.payload;

import com.example.codingbat.repository.AnswerRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;

@Data
public class AnswerDto {

    @NotNull(message = "Field connot be empty")
    private String userReturnText;
    @NotNull(message = "Field connot be empty")
    private Integer taskId;
    @NotNull(message = "Field connot be empty")
    private Integer userId;
    @NotNull(message = "Field connot be empty")
    private boolean test=false;


}
