package com.enigma.cashinout.controller;

import com.enigma.cashinout.entity.Account;
import com.enigma.cashinout.entity.Cash;
import com.enigma.cashinout.service.CashServiceDbImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CashController {

    @Autowired
    CashServiceDbImpl cashService;

    @GetMapping("/cashes")
    public List<Cash> getAllCash() {
        return cashService.getCashes();
    }

    @PostMapping("/cash")
    public Cash addCash(@RequestBody Cash cash) {
        return cashService.addCash(cash);
    }

    @GetMapping("/cashes/{id}")
    public List<Cash> getCashById(@PathVariable String id){
        return cashService.getCashesByAccountId(id);
    }

    @DeleteMapping("/cashes/{id}")
    public void deleteCash(@PathVariable String id){
        cashService.deleteCashById(id);
    }
    @GetMapping("/cashes/debit")
    public List<Cash> getCashesTypeDebit() {
        return cashService.getCashesTypeDebit();
    }
    @GetMapping("/cashes/debit")
    public List<Cash> getCashesTypeCredit() {
        return cashService.getCashesTypeDebit();
    }

}
