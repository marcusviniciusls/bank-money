package br.com.gama.bankmoney.dto;

import br.com.gama.bankmoney.entity.Account;

import java.util.ArrayList;
import java.util.List;

public class ClientDto {
    private Integer id;
    private String name;
    private String cpf;
    private String telephone;
    private String email;
    private List<Account> listAccount = new ArrayList<>();

    public ClientDto(String name, String cpf, String telephone, String email) {
        this.name = name;
        this.cpf = cpf;
        this.telephone = telephone;
        this.email = email;
    }
    
    public ClientDto (){}

    public void setListAccount(List<Account> listAccount) {
        this.listAccount = listAccount;
    }

    public void addListAccount(Account account){
        this.listAccount.add(account);
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public List<Account> getListAccount() {
        return listAccount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
