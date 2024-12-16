package com.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {
    @Id
    private Long transactionId;
    private Double amount;
    private Boolean isSuccess;

    @ManyToOne
    @JoinColumn(name = "userId")
   // @JsonBackReference
    private User user;

    public Transaction() {
    }

    public Transaction(Long transactionId, Double amount, Boolean isSuccess, User user) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.isSuccess = isSuccess;
        this.user = user;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean success) {
        isSuccess = success;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", amount=" + amount +
                ", isSuccess=" + isSuccess +
                ", user=" + user +
                '}';
    }
}
