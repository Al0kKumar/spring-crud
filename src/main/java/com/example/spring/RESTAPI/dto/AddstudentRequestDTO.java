package com.example.spring.RESTAPI.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddstudentRequestDTO {

    @NotBlank(message = "Name is required")
    @Size(min = 3,max = 30,message = "name should be from 3 to 30 length")
    private String name;

    @Email
    @NotBlank(message = "Email is required")
    private String email;
}
