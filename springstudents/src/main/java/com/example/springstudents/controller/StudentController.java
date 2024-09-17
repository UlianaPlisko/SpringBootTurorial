package com.example.springstudents.controller;

import com.example.springstudents.model.Student;
import com.example.springstudents.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> findAllStudents(){
        return studentService.findAllStudents();
    }

    @PostMapping("save_student")
    public String saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return "Student saved successfully";
    }

    @GetMapping("/{email}")
    public Student findByEmail(@PathVariable String email){
        return studentService.findByEmail(email);
    }

    @PutMapping("update_email")
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @DeleteMapping("delete_student/{email}")
    public void deleteStudent(@PathVariable String email){
        studentService.deleteStudent(email);
    }
}
