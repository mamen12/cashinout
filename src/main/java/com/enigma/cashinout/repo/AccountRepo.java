package com.enigma.cashinout.repo;

import com.enigma.cashinout.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepo extends JpaRepository<Account, String> {

    @Modifying
    @Query(value = "SELECT * FROM mst_account", nativeQuery = true)
    List<Account> getAllAccount();

    @Modifying
    @Query(value = "INSERT INTO mst_account(id, name, email, number_phone, address, password) " +
            "values (:id, :name, :email, :numberPhone, :address, :password)", nativeQuery = true)
    public void insertAccount(@Param("id") String id,
                              @Param("name") String name,
                              @Param("email") String email,
                              @Param("numberPhone") String numberPhone,
                              @Param("address") String address,
                              @Param("password") String password);

}

