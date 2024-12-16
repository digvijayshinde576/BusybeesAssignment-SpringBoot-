package com.example.entity;

import jakarta.persistence.*;

@Entity
public class Refund {
    //Amount, UserId, TransactionId

    @Id
    private  Long refundId;
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "userID")
    private  User user;

    @OneToOne
    @JoinColumn(name = "transactionId")
    private Transaction transaction;

    public Refund() {
    }

    public Refund(Long refundId, Double amount, User user, Transaction transaction) {
        this.refundId = refundId;
        this.amount = amount;
        this.user = user;
        this.transaction = transaction;
    }

    public Long getRefundId() {
        return refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "Refund{" +
                "refundId=" + refundId +
                ", amount=" + amount +
                ", user=" + user +
                ", transaction=" + transaction +
                '}';
    }
}
