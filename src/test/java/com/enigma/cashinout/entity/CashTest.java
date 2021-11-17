package com.enigma.cashinout.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashTest {

    @Test
    public void should_createCash(){
        Account account = new Account("syahrul", "Syahrulilham@gmail.com", "08999911000", "Jl Timbul 3", "123arul", "arul123");
        Cash cash = new Cash("gaji harian", "gaji-harian", "abis narik ojek", 100000.0, "DEBIT", "2021-11-17", account);
        assertNotNull(cash);
    }

    @Test
    public void should_createCash_givenInformation(){
        Account account = new Account("syahrul", "Syahrulilham@gmail.com", "08999911000", "Jl Timbul 3", "123arul", "arul123");
        Cash cash = new Cash("gaji harian", "gaji-harian", "abis narik ojek", 100000.0, "DEBIT", "2021-11-17", account);
        Cash cash1 = new Cash("gaji harian", "gaji-harian", "abis narik ojek", 100000.0, "DEBIT", "2021-11-17", account);
        assertEquals(cash, cash1);
    }

    @Test
    public void should_createCash_cant_notSame(){
        Account account = new Account("syahrul", "Syahrulilham@gmail.com", "08999911000", "Jl Timbul 3", "123arul", "arul123");
        Cash cash = new Cash("gaji harian 1", "gaji-harian-1", "abis narik ojek", 100000.0, "DEBIT", "2021-11-17", account);
        Cash cash1 = new Cash("gaji harian 2", "gaji-harian-2", "abis narik ojek", 100000.0, "DEBIT", "2021-11-17", account);
        assertNotEquals(cash, cash1);
    }

    @Test
    public void should_createCash_cant_notSameType(){
        Account account = new Account("syahrul", "Syahrulilham@gmail.com", "08999911000", "Jl Timbul 3", "123arul", "arul123");
        Cash cash = new Cash("gaji harian", "gaji-harian", "abis narik ojek", 100000.0, "DEBIT", "2021-11-17", account);
        Cash cash1 = new Cash("gaji harian", "gaji-harian", "abis narik ojek", -100000.0, "CREDIT", "2021-11-17", account);
        assertNotEquals(cash, cash1);
    }

}