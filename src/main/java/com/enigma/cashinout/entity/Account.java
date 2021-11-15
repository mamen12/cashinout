package com.enigma.cashinout.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "mst_account")
public class Account {

    @Id
    private String id;
    private String name;
    private String email;
    private String numberPhone;
    private String address;
    private String password;

    public Account() {
    }

    public Account(String name, String email, String numberPhone, String address, String password) {
        this.name = name;
        this.email = email;
        this.numberPhone = numberPhone;
        this.address = address;
        this.password = password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(name, account.name) && Objects.equals(email, account.email) && Objects.equals(numberPhone, account.numberPhone) && Objects.equals(address, account.address) && Objects.equals(password, account.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, numberPhone, address, password);
    }
}
