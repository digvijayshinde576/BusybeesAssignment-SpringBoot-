package com.example.service;

import com.example.entity.Transaction;
import com.example.entity.User;

import java.util.List;

public interface PaymentService {
    User addUser(User user);
    Transaction addTransaction(Long userId,Transaction transaction);
    void deleteAllFailedTransaction();
    Long getUserIdWithMaxRefundAmount();
    List<User> getAllUsers();
}
