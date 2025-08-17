package com.example.spring.RESTAPI.controller;

import com.example.spring.RESTAPI.dto.StudentDTO;
import com.example.spring.RESTAPI.entity.Student;
import com.example.spring.RESTAPI.repository.StudentRepository;
import com.example.spring.RESTAPI.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/student")
    public List<StudentDTO> getAllstudent(){
        return studentService.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public StudentDTO getStudent(@PathVariable Long id){
        return studentService.getStudentbyId(id);
    }
}
