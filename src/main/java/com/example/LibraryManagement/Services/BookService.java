package com.example.LibraryManagement.Services;


import com.example.LibraryManagement.Model.Genre;
import com.example.LibraryManagement.Request.BookCreateRequest;
import com.example.LibraryManagement.Model.Author;
import com.example.LibraryManagement.Model.Book;
import com.example.LibraryManagement.Repositories.AuthorRepository;
import com.example.LibraryManagement.Repositories.BookRepository;
import com.example.LibraryManagement.Request.FilterType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {


     @Autowired
     BookRepository bookRepository;

     @Autowired
    AuthorRepository authorRepository;
    public void create(BookCreateRequest bookCreateRequest){
        //convert boocreate request to book obj and save to repository

      Book book = bookCreateRequest.to();
      Author author = book.getAuthor();


      //find if author with given email id exist or not

      Author authorFromDB =authorRepository.findByEmail(author.getEmail())  ;

      if(authorFromDB==null) authorRepository.save(author);
         book.setAuthor(authorFromDB);


        bookRepository.save(book);
    }

    public void create(Book b){
        bookRepository.save(b);
    }

    public List<Book> findBooks(FilterType filterType , String value) {
        switch (filterType) {
            case NAME:
                return bookRepository.findByName(value);

            case AuthorName:
                return bookRepository.findByAuthor_Name(value);

            case Cost:
                 return bookRepository.findByCost(Integer.parseInt(value));
            case BOOKID:
                return bookRepository.findById(Integer.parseInt(value));

            case Genre:
                return bookRepository.findByGenre(Genre.valueOf(value));

            default:
                return new ArrayList<>();



        }
    }
}
