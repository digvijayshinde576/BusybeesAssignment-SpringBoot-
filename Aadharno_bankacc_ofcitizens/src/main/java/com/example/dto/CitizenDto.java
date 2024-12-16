package com.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CitizenDto {
    private Long aadharno;
    private String name;
    private Long panno;
    List<String> bankAccount;

    public CitizenDto() {
    }

    public CitizenDto(Long aadharno, String name, Long panno, List<String> bankAccount) {
        this.aadharno = aadharno;
        this.name = name;
        this.panno = panno;
        this.bankAccount = bankAccount;
    }

    public Long getAadharno() {
        return aadharno;
    }

    public void setAadharno(Long aadharno) {
        this.aadharno = aadharno;
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

    public List<String> getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(List<String> bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return "CitizenDto{" +
                "aadharno=" + aadharno +
                ", name='" + name + '\'' +
                ", panno=" + panno +
                ", bankAccount=" + bankAccount +
                '}';
    }
}
