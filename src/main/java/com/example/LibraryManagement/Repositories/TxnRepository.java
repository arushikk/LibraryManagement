package com.example.LibraryManagement.Repositories;

import com.example.LibraryManagement.Model.Txn;
import com.example.LibraryManagement.Model.TxnType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;

public interface TxnRepository extends JpaRepository<Txn, Integer> {

    @Query(value = "Select * from Txn t where t.book_id =?1 AND t.student_id=?2 AND t.txn_type='ISSUE' Order By t.txn_date Desc" , nativeQuery = true)
    Txn findtxn(int book_id , int student_id , TxnType txnType );
}
