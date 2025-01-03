package com.example.service;

import com.example.entity.Transaction;
import com.example.entity.User;

import com.example.repository.RefundRepository;

import com.example.repository.TransactionRepository;
import com.example.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;


    @Autowired
    private RefundRepository refundRepository;

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


    @Override
    public Long getUserIdWithMaxRefundAmount() {
        return refundRepository.findUserIdWithMaxRefundAmount();
    }

    //Added Paging & Sorting for data Fetching
    @Override
    public Pair<List<User>, Boolean> getAllUsers(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize, Sort.by("name").ascending());
        Page<User> users=userRepository.findAll( pageable);
        List<User> content = users.getContent();
        Boolean aboolean = users.hasNext();

        return Pair.of(content,aboolean);
    }

}
