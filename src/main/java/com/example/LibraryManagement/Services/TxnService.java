package com.example.LibraryManagement.Services;

import com.example.LibraryManagement.Exceptions.TxnException;
import com.example.LibraryManagement.Model.Book;
import com.example.LibraryManagement.Model.Student;
import com.example.LibraryManagement.Model.Txn;
import com.example.LibraryManagement.Model.TxnType;
import com.example.LibraryManagement.Repositories.BookRepository;
import com.example.LibraryManagement.Repositories.TxnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

import static com.example.LibraryManagement.Request.FilterType.BOOKID;

@Service
public class TxnService {

    @Autowired
    StudentService studentService;

    @Autowired
    BookService bookService;
    @Autowired
    private TxnRepository txnRepository;

    @Value("{book.return.due_date")
     String issueddays;

    @Value("{custom.fine}")
    String fine ;
    @Autowired
    private BookRepository bookRepository;


    @Transactional
    public String issueTxn(int  bookId , int  studentId) throws TxnException {
  //find if students exists
        Student s = studentService.findStudentByStudentId(studentId);
        if(s==null) throw new TxnException("student not present");

        //check if book exits

        List<Book> bl = bookService.findBooks(BOOKID , String.valueOf(bookId));
        if(bl== null || bl.get(0).getStudent()==s  )throw new TxnException("book not present or already assigned to this student ");


        Txn txn = Txn.builder()
                .payment(bl.get(0).getCost())
                .txnType(TxnType.ISSUE)
                .book(bl.get(0))
                .student(s)
                .txnExtId(UUID.randomUUID().toString())
                .build();

        txnRepository.save(txn);

        bl.get(0).setStudent(s);
        bookService.create(bl.get(0));

        return txn.getTxnExtId();
    }

    public String returnTxn(int bookId , int studentId) throws TxnException {
        Student s = studentService.findStudentByStudentId(studentId);
        if(s==null) throw new TxnException("student not present");

        //check if book exits

        List<Book> bl = bookService.findBooks(BOOKID , String.valueOf(bookId));
        if(bl== null || bl.get(0).getStudent()!=s  )throw new TxnException("book not present or not assigned to this student ");
        //check if student issued that book

        //create a transaction



        //calculate the fine
       //find original txn
        Txn txn1 = txnRepository.findtxn(bookId,studentId,TxnType.ISSUE);

        System.out.println("result" + txn1);
        if(txn1!=null){
            Txn txn = Txn.builder()
                    .payment(bl.get(0).getCost())
                    .txnType(TxnType.RETURN)
                    .book(bl.get(0))
                    .student(s)
                    .txnExtId(UUID.randomUUID().toString())
                    .build();

            txnRepository.save(txn);
            bl.get(0).setStudent(null);
           bookRepository.save(bl.get(0));
            return txn.getTxnExtId();

            //make the book , foreign key student as null

        }
        return "can't be returned ";
    }

    private int fine(int days){
return 0;
    }
}
