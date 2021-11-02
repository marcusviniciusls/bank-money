package br.com.gama.bankmoney.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account extends SuperEntity{
    
    private BigDecimal balance;
    private int agency;
    private String accountNumber;
    
    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private Client client;
    
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Historic> listHistoric = new ArrayList<>(); 

    public Account(BigDecimal balance, int agency, String accountNumber, Client client) {
        this.balance = balance;
        this.agency = agency;
        this.accountNumber = accountNumber;
        this.client = client;
    }

    public Account(){}

    public BigDecimal getBalance() {
        return balance;
    }

    public int getAgency() {
        return agency;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Client getClient() {
        return client;
    }
}
