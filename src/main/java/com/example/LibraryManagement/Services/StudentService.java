package com.example.LibraryManagement.Services;


import com.example.LibraryManagement.Repositories.BookRepository;
import com.example.LibraryManagement.Request.FilterType;
import com.example.LibraryManagement.Request.StudentCreateRequest;
import com.example.LibraryManagement.Model.Student;
import com.example.LibraryManagement.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository ;
    @Autowired
    private BookRepository bookRepository;


    public void create(StudentCreateRequest studentCreateRequest){
        Student student = studentCreateRequest.to();
        studentRepository.save(student);

    }

    public List<Student> find(FilterType filterType , String value){
        switch(filterType){
            case Name :
                return studentRepository.findByName(value);
            case Contact:
                return studentRepository.findByContact(value);



        }
        return null;
    }

    public Student findStudentByStudentId(int studentId){
        return studentRepository.findById(studentId);
    }
}
