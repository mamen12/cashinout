package com.enigma.cashinout.controller;

import com.enigma.cashinout.dto.UserCredentials;
import com.enigma.cashinout.entity.Account;
import com.enigma.cashinout.security.JwtTokenUtil;
import com.enigma.cashinout.service.AccountServiceDbImpl;
import com.enigma.cashinout.service.UserDetailsServiceDbImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AccountController {

    @Autowired
    AccountServiceDbImpl accountService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserDetailsServiceDbImpl userDetailService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenUtil jwtTokenUtil;



    @PostMapping("/signin")
    public Map<String, Object> signin(@RequestBody UserCredentials userCredentials){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(userCredentials.getUsername(), userCredentials.getPassword());

        //validate username dan password
        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        //ambil UserDetails
        UserDetails userDetails = userDetailService.loadUserByUsername(userCredentials.getUsername());

        String token = jwtTokenUtil.generateToken(userDetails);

        Map<String, Object> tokenWrapper = new HashMap<>();
        tokenWrapper.put("token", token);

        return tokenWrapper;
    }

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
