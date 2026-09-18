package com.example.lab9.service;

import com.example.lab9.model.Account;
import com.example.lab9.model.DepositTransaction;
import com.example.lab9.repository.AccountRepository;
import com.example.lab9.repository.DepositRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepositService {
    private final AccountRepository accountRepository;
    private final DepositRepository depositRepository;

    public DepositService(AccountRepository accountRepository,
            DepositRepository depositRepository) {
        this.accountRepository = accountRepository;
        this.depositRepository = depositRepository;
    }

    // @Transactional
    public DepositTransaction deposit(Long accountId, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero");
        }

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found: " + accountId));

        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);

        DepositTransaction transaction = new DepositTransaction();
        transaction.setAccount(account);
        transaction.setAmount(amount);
        throw new RuntimeException("Test Rollback");
        // return depositRepository.save(transaction);
    }
}
