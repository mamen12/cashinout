package com.enigma.cashinout.service;

import com.enigma.cashinout.entity.Account;
import com.enigma.cashinout.repo.AccountRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class AccountServiceDbImplTest {

    @Autowired
    AccountRepo accountRepo;

    @Autowired
    AccountServiceDbImpl accountService;

    @BeforeEach
    public void reset(){
        accountRepo.deleteAll();
    }

    @Test
    public void able_to_createAccount(){
        Account account = new Account("syahrul", "Syahrulilham@gmail.com", "08999911000", "Jl Timbul 3", "123arul", "arul123");
        accountService.register(account);
        Long count = accountRepo.count();
        assertEquals(1, count);
    }

    @Test
    public void able_to_createTwoAccount(){
        Account account1 = new Account("syahrul", "Syahrulilham@gmail.com", "08999911000", "Jl Timbul 3", "123arul", "arul123");
        Account account2 = new Account("syahrul ilham", "syahrulilham62@gmail.com", "08999911000", "Jl Timbul 3", "123arul", "arul122");
        accountService.register(account1);
        accountService.register(account2);
        Long count = accountRepo.count();
        assertEquals(2, count);
    }

    @Test
    public void findAll_shouldHaveSizeOfTwo_when_TwoAccountSaved(){
        Account account1 = new Account("syahrul", "Syahrulilham@gmail.com", "08999911000", "Jl Timbul 3", "123arul", "arul123");
        Account account2 = new Account("syahrul ilham", "syahrulilham62@gmail.com", "08999911000", "Jl Timbul 3", "123arul", "arul122");
        accountService.register(account1);
        accountService.register(account2);

        Integer count = accountService.findAllAccount().size();

        assertEquals(2, count);
    }

    @Test
    public void findAll_shouldReturnCorrectList_when_TwoAccountSaved(){
        Account account1 = new Account("syahrul", "Syahrulilham@gmail.com", "08999911000", "Jl Timbul 3", "123arul", "arul123");
        Account account2 = new Account("syahrul ilham", "syahrulilham62@gmail.com", "08999911000", "Jl Timbul 3", "123arul", "arul122");
        accountService.register(account1);
        accountService.register(account2);

        List<Account> expectedAccount = new ArrayList<>();
        expectedAccount.add(account1);
        expectedAccount.add(account2);

        assertEquals(expectedAccount,accountService.findAllAccount());
    }

    @Test
    public void getById_shouldReturnAccountId_correctId(){
        Account account = new Account("syahrul", "Syahrulilham@gmail.com", "08999911000", "Jl Timbul 3", "123arul", "arul123");
        accountService.register(account);

        assertEquals(account, accountService.getAccountId(account.getId()));
    }



}