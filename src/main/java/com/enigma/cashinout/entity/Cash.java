package com.enigma.cashinout.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "mst_cash")
public class Cash {
    @Id
    private String id;
    private String name;
    private String slug;
    private String description;
    private Double amount;
    private String type;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String whenTransaction;

    @Transient
    private String accountIdTransient;


    @ManyToOne
    @JoinColumn(name = "accountId", nullable = false)
    private Account account;

    public Cash() {
    }

    public Cash(String name, String slug, String description, Double amount, String type, String whenTransaction, Account account) {
        this.name = name;
        this.slug = slug;
        this.description = description;
        this.amount = amount;
        this.whenTransaction = whenTransaction;
        this.account = account;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setWhenTransaction(String whenTransaction) {
        this.whenTransaction = whenTransaction;
    }

    public String getId() {
        return id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public String getDescription() {
        return description;
    }

    public Double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getWhenTransaction() {
        return whenTransaction;
    }
    @JsonIgnore
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getAccountIdTransient() {
        return accountIdTransient;
    }



}
