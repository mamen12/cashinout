package com.enigma.cashinout.repo;

import com.enigma.cashinout.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<Account, String> {

    @Modifying
    @Query(value = "SELECT * FROM mst_account", nativeQuery = true)
    List<Account> getAllAccount();

    @Modifying
    @Query(value = "INSERT INTO mst_account(id, name, email, number_phone, ballance, address, password, username) " +
            "values (:id, :name, :email, :numberPhone, :ballance, :address, :password, :username)", nativeQuery = true)
    public void insertAccount(@Param("id") String id,
                              @Param("name") String name,
                              @Param("email") String email,
                              @Param("numberPhone") String numberPhone,
                              @Param("ballance") Double ballance,
                              @Param("address") String address,
                              @Param("password") String password,
                              @Param("username") String username);

    @Query(value = "SELECT * FROM mst_account WHERE id = :id", nativeQuery = true)
    public Account getAccountById(@Param("id") String id);

    @Modifying
    @Query(value = "DELETE FROM mst_account WHERE id = :id", nativeQuery = true)
    public void deleteAccountById(@Param("id") String id);


    public Optional<Account> findAccountByUsername(String username);


}

