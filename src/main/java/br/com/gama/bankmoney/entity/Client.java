package br.com.gama.bankmoney.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client extends SuperEntity {

    private String name;
    private String cpf;
    private String telephone;
    private String email;
    
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Account> listAccount = new ArrayList<>();

    public Client(String name, String cpf, String telephone) {
        this.name = name;
        this.cpf = cpf;
        this.telephone = telephone;
    }

    public Client(String name, String cpf, String telephone, String email) {
        this.name = name;
        this.cpf = cpf;
        this.telephone = telephone;
        this.email = email;
    }
    
    public Client(){}
    
    public void addAccount(Account account){
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
}    
