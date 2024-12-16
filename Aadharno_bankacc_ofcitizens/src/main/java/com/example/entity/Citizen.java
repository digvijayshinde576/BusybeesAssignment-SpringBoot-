package com.example.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "aadharno")
    private Long aadharno;
    private String name;
    @Column(name = "panno")
    private Long panno;
    List<String> bankAccount;

    public Citizen() {
    }

    public Citizen( String name, Long panno, Long aadharno, List<String> bankAccount) {

        this.name = name;
        this.panno = panno;
        this.aadharno = aadharno;
        this.bankAccount = bankAccount;
    }

    public List<String> getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(List<String> bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPanno() {
        return panno;
    }

    public void setPanno(Long panno) {
        this.panno = panno;
    }

    public Long getAadharno() {
        return aadharno;
    }

    public void setAadharno(Long aadharno) {
        this.aadharno = aadharno;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                ", name='" + name + '\'' +
                ", panno=" + panno +
                ", aadharno=" + aadharno +
                '}';
    }
}
