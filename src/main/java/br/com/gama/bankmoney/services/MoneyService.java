package br.com.gama.bankmoney.services;

import br.com.gama.bankmoney.controller.exception.BankWithoutMoneyException;
import br.com.gama.bankmoney.dto.MoneyDto;
import br.com.gama.bankmoney.entity.Money;
import br.com.gama.bankmoney.factory.MoneyFactory;
import br.com.gama.bankmoney.repository.MoneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MoneyService {
    
    @Autowired
    private MoneyRepository moneyRepository;
    
    public Integer totalBankValue(){
        List<Money> listMoney = moneyRepository.findAll();
        if(listMoney.isEmpty()){
            throw new BankWithoutMoneyException("BANK WITHOUT MONEY");
        }
        Integer value = 0;
        for (Money money : listMoney){
            value += money.getQuantity() * money.getNote().getValue();    
        }
        return value;   
    }
    
    public List<MoneyDto> findByAll(){
        List<Money> listMoney = moneyRepository.findAll();
        return listMoney.stream().map(MoneyFactory::convertMoneyDto).collect(Collectors.toList());
    }
    
    public void saveAll(List<Money> listMoney){
        moneyRepository.saveAll(listMoney);
    }
}
