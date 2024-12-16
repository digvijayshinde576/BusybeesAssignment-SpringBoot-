package com.example.repository;

import com.example.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    void deleteByIsSuccessIsFalse();//Give Query for deleting transaction which has false Transaction
}
