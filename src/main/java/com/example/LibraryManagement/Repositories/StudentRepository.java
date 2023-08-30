package com.example.LibraryManagement.Repositories;

import com.example.LibraryManagement.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student , Integer> {
    List<Student> findByName(String value);
    List<Student> findByContact(String value);

    Student findById(int studentId);
}
