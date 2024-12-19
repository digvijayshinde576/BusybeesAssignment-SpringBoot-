package com.example.controller;

import com.example.entity.Transaction;
import com.example.entity.User;
import com.example.service.PaymentService;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

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
    @GetMapping("/getAllUsers")
    public  List<List<User>> getAllUsers() {
        int pageNumber=0;
        int pageSize=1;
        List<List<User>> allUsers=new ArrayList<>();

        while (true) {
            Pair<List<User>, Boolean> result=paymentService.getAllUsers(pageNumber,pageSize);
            List<User> userList=result.getLeft();
            Boolean aBoolean = result.getRight();

            if(userList.isEmpty()) break;
            allUsers.add(userList);
            if(!aBoolean) break;
            pageNumber++;

        }
        return allUsers;
    }


}
