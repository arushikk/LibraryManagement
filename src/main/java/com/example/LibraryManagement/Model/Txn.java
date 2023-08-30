package com.example.LibraryManagement.Model;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Txn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Enumerated(value=EnumType.STRING)
    private TxnType txnType ;

    private double payment ;


    @ManyToOne
    @JoinColumn //Many transaction can have one book
    private Book book;

    @ManyToOne
    @JoinColumn
    private Student student ;

    @CreationTimestamp
    private Date  txnDate;

    @Column(unique = true)
    private String txnExtId;

}
