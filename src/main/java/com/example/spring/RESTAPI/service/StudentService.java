package com.example.spring.RESTAPI.service;

import com.example.spring.RESTAPI.dto.AddstudentRequestDTO;
import com.example.spring.RESTAPI.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    List<StudentDTO> getAllStudents();

    StudentDTO getStudentbyId(Long id);

    StudentDTO createnewStudent(AddstudentRequestDTO addstudentRequestDTO);
}
