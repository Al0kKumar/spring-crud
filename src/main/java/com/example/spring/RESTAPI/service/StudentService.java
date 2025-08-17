package com.example.spring.RESTAPI.service;

import com.example.spring.RESTAPI.dto.AddstudentRequestDTO;
import com.example.spring.RESTAPI.dto.StudentDTO;

import java.util.List;
import java.util.Map;

public interface StudentService {

    List<StudentDTO> getAllStudents();

    StudentDTO getStudentbyId(Long id);

    StudentDTO createnewStudent(AddstudentRequestDTO addstudentRequestDTO);

    void deletestudentbyid(Long id);

    StudentDTO updateStudent(Long id, AddstudentRequestDTO addstudentRequestDTO);

    StudentDTO updatePartialStudent(Long id, Map<String, Object> updates);
}
