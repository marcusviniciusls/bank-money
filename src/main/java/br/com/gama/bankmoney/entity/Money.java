package br.com.gama.bankmoney.entity;

import br.com.gama.bankmoney.entity.enums.Note;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "money")
public class Money extends SuperEntity{
    
    private Integer quantity;
    @Enumerated(EnumType.ORDINAL)
    private Note note;

    public Money(Integer quantity, Note note) {
        this.quantity = quantity;
        this.note = note;
    }
    
    public Money(){}

    public Integer getQuantity() {
        return quantity;
    }

    public Note getNote() {
        return note;
    }
}
