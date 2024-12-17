package com.example.service;

import com.example.entity.Transaction;
import com.example.entity.User;
<<<<<<< HEAD
import com.example.repository.RefundRepository;
=======
>>>>>>> f62d505eeb846056fc9cb1173cd950f18fed7268
import com.example.repository.TransactionRepository;
import com.example.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;

<<<<<<< HEAD
    @Autowired
    private RefundRepository refundRepository;

=======
>>>>>>> f62d505eeb846056fc9cb1173cd950f18fed7268
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Transaction addTransaction(Long userId, Transaction transaction) {
        User user=userRepository.findById(userId).orElseThrow(()->new RuntimeException("UserId Not Found....."));
        transaction.setUser(user);
      return   transactionRepository.save(transaction);

    }

    @Override
    public void deleteAllFailedTransaction() {
        transactionRepository.deleteByIsSuccessIsFalse();
    }
<<<<<<< HEAD

    @Override
    public Long getUserIdWithMaxRefundAmount() {
        return refundRepository.findUserIdWithMaxRefundAmount();
    }
=======
>>>>>>> f62d505eeb846056fc9cb1173cd950f18fed7268
}
