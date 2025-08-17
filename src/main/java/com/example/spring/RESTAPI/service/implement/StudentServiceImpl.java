package com.example.spring.RESTAPI.service.implement;

import com.example.spring.RESTAPI.dto.StudentDTO;
import com.example.spring.RESTAPI.entity.Student;
import com.example.spring.RESTAPI.repository.StudentRepository;
import com.example.spring.RESTAPI.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDTO> getAllStudents(){
        List<Student> students = studentRepository.findAll();

        List<StudentDTO> studentDTOList = students.stream()
                .map(student -> new StudentDTO(student.getId(),
                        student.getName(),student.getEmail())).toList();

        return studentDTOList;
    }

    @Override
    public StudentDTO getStudentbyId(Long id){
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("user not found with this Id"+id));

        return modelMapper.map(student,StudentDTO.class);
    }
}
