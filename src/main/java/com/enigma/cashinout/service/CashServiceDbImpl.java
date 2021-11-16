package com.enigma.cashinout.service;

import com.enigma.cashinout.entity.Account;
import com.enigma.cashinout.entity.Cash;
import com.enigma.cashinout.repo.AccountRepo;
import com.enigma.cashinout.repo.CashRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class CashServiceDbImpl {

    @Autowired
    CashRepo cashRepo;

    @Autowired
    AccountServiceDbImpl accountService;


    public List<Cash> getCashes() {
        return cashRepo.getAllCash();
    }

    @Transactional
    public Cash addCash(Cash cash) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        cash.setId(uuid);
        String slug = cash.getName().replace(" ", "-");
        cash.setSlug(slug);
        Account account = accountService.getAccountId(cash.getAccountIdTransient());
        cash.setAccount(account);
        if (cash.getAmount() < 0) {
            account.setBallance(account.getBallance() + cash.getAmount());
            cash.setType("CREDIT");
        } else {
            account.setBallance(account.getBallance() + cash.getAmount());
            cash.setType("DEBIT");
        }
        long datein = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date resultDate = new Date(datein);
        cash.setWhenTransaction(sdf.format(resultDate));

        cashRepo.addCash(cash.getId(), cash.getName(), cash.getSlug(), cash.getDescription(), cash.getAmount(), cash.getType(), cash.getWhenTransaction(), cash.getAccount().getId());
        return cash;
    }

    public List<Cash> getCashesByAccountId(String id) {
        LocalDate awal = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        LocalDate end = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        String tanggalAwal = awal.toString();
        String tanggalAkhir = end.toString();
        return cashRepo.getAllCashByIdAccount(id, tanggalAwal, tanggalAkhir);
    }

    public List<Cash> getCashesTypeDebit(){
        List<Cash> data = cashRepo.getAllCash();

        return data.stream()
                .filter(cash -> cash.getType().equals("DEBIT"))
                .collect(Collectors.toList());
    }
    public List<Cash> getCashesTypeCredit(){
        List<Cash> data = cashRepo.getAllCash();

        return data.stream()
                .filter(cash -> cash.getType().equals("CREDIT"))
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteCashById(String id) {
        cashRepo.deleteCashById(id);
    }
}
