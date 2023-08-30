package com.example.LibraryManagement.Model;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private String name ;
    private String country ;
    private int age ;

    @OneToMany(mappedBy = "author" , fetch =FetchType.EAGER)
    private List<Book> bookList;


    @Column(nullable=false , unique = true )
    private String email ;


}
