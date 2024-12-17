package com.example.service;

import com.example.entity.Transaction;
import com.example.entity.User;

public interface PaymentService {
    User addUser(User user);
    Transaction addTransaction(Long userId,Transaction transaction);
    void deleteAllFailedTransaction();
    Long getUserIdWithMaxRefundAmount();
}
