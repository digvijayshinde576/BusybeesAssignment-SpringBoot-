package com.example.controller;

import com.example.entity.Transaction;
import com.example.entity.User;
import com.example.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        return new ResponseEntity<>(paymentService.addUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/addTransaction/{userId}")
    public ResponseEntity<?> addTransaction(@PathVariable Long userId, @RequestBody Transaction transaction) {
        return new ResponseEntity<>(paymentService.addTransaction(userId, transaction), HttpStatus.CREATED);

    }

    @DeleteMapping("/deleteFailedTransaction")
    public ResponseEntity<?> deleteAllFailedTransaction() {
        paymentService.deleteAllFailedTransaction();
        return new ResponseEntity<>("Successfully Deleted Failed Transaction..... ",HttpStatus.OK);
    }


    @GetMapping("/max")
    public ResponseEntity<?> getUserIdWithMaxRefundAmount() {
        return new ResponseEntity<>("UserId With Max Refund Amount Is = "+paymentService.getUserIdWithMaxRefundAmount(),HttpStatus.FOUND);
    }

}
