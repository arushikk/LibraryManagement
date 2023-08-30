package com.example.LibraryManagement.Repositories;

import com.example.LibraryManagement.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {


    Author findByEmail(String email);
   List<Author> findByAgeGreaterThanAndCountry(int Age , String Country) ;
}
