package com.enigma.cashinout.entity;
import javax.persistence.*;
import java.util.List;
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
    private String username;
    private String password;
    private Double ballance = 0.0;



    @OneToMany(mappedBy = "account")
    private List<Cash> cashes;


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

    public void setBallance(Double ballance) {
        this.ballance = ballance;
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

    public Double getBallance() {
        return ballance;
    }

    public List<Cash> getCashes() {
        return cashes;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
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
