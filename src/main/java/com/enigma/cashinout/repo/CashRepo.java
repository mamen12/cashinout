package com.enigma.cashinout.repo;

import com.enigma.cashinout.entity.Account;
import com.enigma.cashinout.entity.Cash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
public interface CashRepo extends JpaRepository<Cash, String> {

    @Query(value = "SELECT * FROM mst_cash", nativeQuery = true)
    List<Cash> getAllCash();

    @Query(value = "SELECT * FROM mst_cash u where  u.account_id = :accountId AND when_transaction BETWEEN :start AND :end", nativeQuery = true)
    List<Cash> getAllCashByIdAccount(@Param("accountId") String accountId,
                                     @Param("start") String start,
                                     @Param("end") String end);


    @Modifying
    @Query(value = "INSERT INTO mst_cash(id, name, slug, description, amount, type, when_transaction, account_id) " +
            "values (:id, :name, :slug, :description, :amount, :type, :whenTransaction, :account_id)", nativeQuery = true)
    public void addCash(
            @Param("id") String id,
            @Param("name") String name,
            @Param("slug") String slug,
            @Param("description") String description,
            @Param("amount") Double amount,
            @Param("type") String type,
            @Param("whenTransaction") String whenTransaction,
            @Param("account_id") String account_id
    );
    @Modifying
    @Query(value = "DELETE FROM mst_cash WHERE id = :id", nativeQuery = true)
    public void deleteCashById(@Param("id") String id);


}
