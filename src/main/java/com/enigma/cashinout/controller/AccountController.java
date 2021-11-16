package com.enigma.cashinout.controller;

import com.enigma.cashinout.entity.Account;
import com.enigma.cashinout.service.AccountServiceDbImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountServiceDbImpl accountService;

    @GetMapping("/accounts")
    public List<Account> getAllAcount(){
        return accountService.findAllAccount();
    }

    @PostMapping("/register")
    public Account register(@RequestBody Account account){
        return accountService.register(account);
    }

    @GetMapping("/accounts/{id}")
    public Account getAccountById(@PathVariable String id){
        return accountService.getAccountId(id);
    }
}
