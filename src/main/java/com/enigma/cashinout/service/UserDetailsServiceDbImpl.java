package com.enigma.cashinout.service;

import com.enigma.cashinout.dto.UserDetailsImpl;
import com.enigma.cashinout.entity.Account;
import com.enigma.cashinout.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceDbImpl implements UserDetailsService {

    @Autowired
    AccountRepo accountRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!accountRepo.findAccountByUsername(username).isPresent()){
            throw new UsernameNotFoundException("Data tidak ditemukan!");
        }

        Account account = accountRepo.findAccountByUsername(username).get();

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("Admin"));

        UserDetails userDetails = new UserDetailsImpl(account.getUsername(), account.getPassword(), authorities);
        return userDetails;
    }
}
