package br.com.gama.bankmoney.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "historic")
public class Historic extends SuperEntity{
    
    private LocalDateTime dateTime;
    private Double value;
    
    @ManyToOne
    @JoinColumn(name = "historic_id")
    @JsonIgnore
    private Account account;

    public Historic(Double value, Account account) {
        this.dateTime = dateTime = LocalDateTime.now();;
        this.value = value;
        this.account = account;
    }
    
    public Historic(){}

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Double getValue() {
        return value;
    }

    public Account getAccount() {
        return account;
    }
}
