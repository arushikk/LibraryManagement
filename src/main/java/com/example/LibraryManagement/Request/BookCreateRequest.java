package com.example.LibraryManagement.Request;

import com.example.LibraryManagement.Model.Author;
import com.example.LibraryManagement.Model.Book;
import com.example.LibraryManagement.Model.Genre;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class BookCreateRequest {

    @NotBlank
    private String name ;

    @NotNull
    private Author author ;

    @Positive
    private int cost ;

    @NotNull
    private Genre genre;

    //conv to book obj

    public Book to (){
        return Book.builder()
                .author(this.author)
                .cost(this.cost)
                .genre(this.genre)
                .name(this.name)
                .build();

    }

}
