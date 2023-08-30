package com.example.LibraryManagement.Controllers;

import com.example.LibraryManagement.Request.BookCreateRequest;
import com.example.LibraryManagement.Model.Book;
import com.example.LibraryManagement.Request.FilterType;
import com.example.LibraryManagement.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BookController {


    @Autowired
    BookService bookService;


    //Inserting a book into the book database
    @PostMapping("/book")
    public void createBook(@RequestBody BookCreateRequest bookCreateRequest){
        bookService.create(bookCreateRequest);
    }


    //filtering a book on the basis of genere
    @GetMapping("/books")
    public List<Book> getBooks(@RequestParam("filter") FilterType filterType , @RequestParam("value") String value){
      return bookService.findBooks(filterType , value);

    }
}
