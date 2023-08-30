package com.example.LibraryManagement.Controllers;

import com.example.LibraryManagement.Model.Student;
import com.example.LibraryManagement.Request.FilterType;
import com.example.LibraryManagement.Request.StudentCreateRequest;
import com.example.LibraryManagement.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

   @Autowired
    StudentService studentService;


    @PostMapping("/student")
    public void createStudent(@RequestBody StudentCreateRequest studentCreateRequest){
        studentService.create(studentCreateRequest);

    }

    @GetMapping("/students")
    public List<Student> findStudents(@RequestParam("filter")FilterType filterType , @RequestParam("value") String value ){
         return studentService.find(filterType, value);


    }
}
