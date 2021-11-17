package com.enigma.cashinout.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    public void able_to_createdAcount(){
        Account account = new Account("syahrul", "Syahrulilham@gmail.com", "08999911000", "Jl Timbul 3", "123arul", "arul123");
        assertNotNull(account);
    }

    @Test
    public  void able_to_createdAccount_with_given_information(){
        Account expectedAccount  = new Account("syahrul", "Syahrulilham@gmail.com", "08999911000", "Jl Timbul 3", "123arul", "arul123");
        Account actualsAccount  = new Account("syahrul", "Syahrulilham@gmail.com", "08999911000", "Jl Timbul 3", "123arul", "arul123");
        assertEquals(expectedAccount, actualsAccount);
    }

    @Test
    public void able_to_createAccount_cant_beTheSame(){
        Account expectedAccount  = new Account("syahrul", "Syahrulilham@gmail.com", "08999911000", "Jl Timbul 3", "123arul", "arul123");
        Account actualsAccount  = new Account("syahrul ilham", "Syahrulilham@gmail.com", "08999911000", "Jl Timbul 3", "123arul", "arul123");
        assertNotEquals(expectedAccount, actualsAccount);
    }

}