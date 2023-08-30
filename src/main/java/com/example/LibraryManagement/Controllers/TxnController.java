package com.example.LibraryManagement.Controllers;


import com.example.LibraryManagement.Exceptions.TxnException;
import com.example.LibraryManagement.Services.TxnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TxnController {

    @Autowired
    TxnService txnService;

    @PostMapping("/txn")
    public String issueTxn(@RequestParam ( "bookId") int bookId , @RequestParam("studentId") int studentId) throws TxnException {
        return txnService.issueTxn(bookId,studentId);
    }

   @PostMapping("/returnTxn")
    public String returntxn (@RequestParam ( "bookId") int bookId , @RequestParam("studentId") int studentId) throws TxnException {
        return txnService.returnTxn(bookId,studentId);
   }
}
