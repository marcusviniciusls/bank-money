package br.com.gama.bankmoney.factory;

import br.com.gama.bankmoney.dto.ClientDto;
import br.com.gama.bankmoney.dto.MoneyDto;
import br.com.gama.bankmoney.entity.Client;
import br.com.gama.bankmoney.entity.Money;
import br.com.gama.bankmoney.entity.enums.Note;
import br.com.gama.bankmoney.form.ClientForm;
import br.com.gama.bankmoney.repository.AccountRepository;

public class MoneyFactory {
    
    public static MoneyDto convertMoneyDto(Money money){
        MoneyDto moneyDto = new MoneyDto();
        moneyDto.setQuantidade(money.getQuantity());
        moneyDto.setValueNote(money.getNote().getValue());

        return moneyDto;
    }

    public static Money convertMoney(MoneyDto moneyDto){
        Money money = null;
        if(moneyDto.getValueNote() == 100){
            money = new Money(moneyDto.getQuantidade(), Note.CEM);    
        }
        else if(moneyDto.getValueNote() == 50){
            money = new Money(moneyDto.getQuantidade(), Note.CINQUENTA);
        }
        else if(moneyDto.getValueNote() == 20){
            money = new Money(moneyDto.getQuantidade(), Note.VINTE);
        }
        else if(moneyDto.getValueNote() == 10){
            money = new Money(moneyDto.getQuantidade(), Note.DEZ);
        }
        else if(moneyDto.getValueNote() == 5){
            money = new Money(moneyDto.getQuantidade(), Note.CINCO);
        }
        else if(moneyDto.getValueNote() == 5){
            money = new Money(moneyDto.getQuantidade(), Note.CINCO);
        }
        return money;
    }
}
