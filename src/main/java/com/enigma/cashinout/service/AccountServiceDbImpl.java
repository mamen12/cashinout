package com.enigma.cashinout.service;

import com.enigma.cashinout.entity.Account;
import com.enigma.cashinout.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class AccountServiceDbImpl {

    @Autowired
    AccountRepo accountRepo;

    public List<Account> findAllAccount(){return accountRepo.getAllAccount();}


    @Transactional
    public Account register(Account account){
        String uuid = UUID.randomUUID().toString().replace("-", "");
        account.setId(uuid);
        accountRepo.insertAccount(account.getId(), account.getName(), account.getEmail(), account.getNumberPhone(), account.getBallance(), account.getAddress(), account.getPassword());
        return account;
    }

    @Transactional
    public Account getAccountId(String id){
        return accountRepo.getAccountById(id);
    }



}

