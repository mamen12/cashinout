package com.enigma.cashinout.service;

import com.enigma.cashinout.entity.Account;
import com.enigma.cashinout.entity.Cash;
import com.enigma.cashinout.repo.AccountRepo;
import com.enigma.cashinout.repo.CashRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class CashServiceDbImplTest {

    @Autowired
    CashRepo cashRepo;

    @Autowired
    CashServiceDbImpl cashService;

    @Autowired
    AccountServiceDbImpl accountService;

    @Test
    public void able_createAccountCash(){
        Account account = new Account("syahrul", "Syahrulilham@gmail.com", "08999911000", "Jl Timbul 3", "123arul", "arul123");
        accountService.register(account);

        Cash cash = new Cash("gaji harian", "gaji-harian", "abis narik ojek", 100000.0, account.getId());
        cashService.addCash(cash);
        assertNotNull(cashRepo.getAllCash());
    }

    @Test
    public void able_to_createAccountTwoCash(){
        Account account = new Account("syahrul", "Syahrulilham@gmail.com", "08999911000", "Jl Timbul 3", "123arul", "arul123");
        accountService.register(account);

        Cash cash1 = new Cash("gaji harian", "gaji-harian", "abis narik ojek", 100000.0, account.getId());
        Cash cash2 = new Cash("beli sembako", "beli-sembako", "beli kebutuhan seminggu", -80000.0, account.getId());
        cashService.addCash(cash1);
        cashService.addCash(cash2);
        Long count = cashRepo.count();
        assertEquals(2, count);
    }

}