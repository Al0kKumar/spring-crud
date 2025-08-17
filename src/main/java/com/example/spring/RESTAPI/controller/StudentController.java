package com.example.spring.RESTAPI.controller;

import com.example.spring.RESTAPI.dto.AddstudentRequestDTO;
import com.example.spring.RESTAPI.dto.StudentDTO;
import com.example.spring.RESTAPI.entity.Student;
import com.example.spring.RESTAPI.repository.StudentRepository;
import com.example.spring.RESTAPI.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/student")
    public ResponseEntity<List<StudentDTO>> getAllstudent(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentbyId(id));
    }

    @PostMapping("/student")
    public ResponseEntity<StudentDTO> createStudent(@RequestBody @Valid AddstudentRequestDTO addstudentRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createnewStudent(addstudentRequestDTO));
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Void> deletestudent(@PathVariable Long id){
        studentService.deletestudentbyid(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id, @RequestBody AddstudentRequestDTO addstudentRequestDTO){
        return ResponseEntity.ok(studentService.updateStudent(id,addstudentRequestDTO));
    }

    @PatchMapping("/student/{id}")
    public ResponseEntity<StudentDTO> updatePartialStudent(@PathVariable Long id, @RequestBody Map<String, Object> updates){
        return ResponseEntity.ok(studentService.updatePartialStudent(id,updates));
    }
}
