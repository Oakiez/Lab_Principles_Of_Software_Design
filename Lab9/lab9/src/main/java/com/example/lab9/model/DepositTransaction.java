package com.example.lab9.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DepositTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public DepositTransaction() {
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public double getAmount() {
        return amount;
    }

    public Long getId() {
        return id;
    }

}
