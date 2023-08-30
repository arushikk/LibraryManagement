package com.example.LibraryManagement.Model;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;

    private String name ;

    @Column(unique = true , nullable = false)
    private String contact ;
    private String address;

    @Column(unique = true)
    private String email;


    @CreationTimestamp
    private Date creationOn;

    @UpdateTimestamp
    private Date UpdatedOn;


    @OneToMany(mappedBy = "student")
    private List<Book> booklist ;

    @OneToMany(mappedBy = "student")
    private List<Txn> txnlist;

    @Enumerated(value=EnumType.STRING)
    private AccountStatus accountStatus;


}
