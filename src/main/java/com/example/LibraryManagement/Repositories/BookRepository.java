package com.example.LibraryManagement.Repositories;

import com.example.LibraryManagement.Model.Book;
import com.example.LibraryManagement.Model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

   // @Query("Update book set student_id=NULL where id=book_id")
   // Book update(int book_id);
    List<Book> findByName(String Name);
    List<Book> findByAuthor_Name(String value);

    List<Book> findByCost(int value);

    List<Book> findByGenre(Genre value);

    List<Book> findById(int id);
}
