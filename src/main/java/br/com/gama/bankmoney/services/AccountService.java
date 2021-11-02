package br.com.gama.bankmoney.services;

import br.com.gama.bankmoney.controller.exception.BankWithoutMoneyException;
import br.com.gama.bankmoney.controller.exception.ResourceNotFoundException;
import br.com.gama.bankmoney.controller.exception.StandardErrorWithdrawException;
import br.com.gama.bankmoney.controller.exception.WithoutBalanceException;
import br.com.gama.bankmoney.dto.MoneyDto;
import br.com.gama.bankmoney.entity.Account;
import br.com.gama.bankmoney.entity.Historic;
import br.com.gama.bankmoney.entity.Money;
import br.com.gama.bankmoney.factory.MoneyFactory;
import br.com.gama.bankmoney.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    
    @Autowired
    private AccountRepository accountRepository;
    
    @Autowired
    private MoneyService moneyService;

    @Autowired
    private HistoryService historyService; 
    
    public void withdraw(Integer idAccount, Double value){
        Double balance = accountRepository.findByAccountBalance(idAccount);
        List<MoneyDto> listMoney = moneyService.findByAll();
        if(value > balance){
            throw new WithoutBalanceException("Account without Sufficient Balance for Withdrawal");    
        } else if(value > moneyService.totalBankValue()){
            throw new BankWithoutMoneyException("Bamk Without Money");    
        } else if(value <= 0){
            throw new StandardErrorWithdrawException("Negative Value Not Supported");    
        } else if(isPossibleWithdraw(value,listMoney)){
            Optional<Account> account = accountRepository.findById(idAccount);
            if(account.isEmpty()){
                throw new ResourceNotFoundException("ID not found");
            }
            Historic historic = new Historic(value,account.get());
            historyService.save(historic);            
        } 
    }
    
    private boolean isPossibleWithdraw(Double value, List<MoneyDto> listMoney){
        valueBroken(value, listMoney);
        if(enoughGrades(value,listMoney)){
            return true;    
        } else {
            return false;
        }
    }
    
    private void valueBroken(Double value, List<MoneyDto> listMoney){
        String valueString = value.toString();
        int ponitCut = valueString.indexOf(".");
        Integer valueDecimal = Integer.parseInt(valueString.substring(ponitCut+1));
        if(valueDecimal > 0){
            throw new StandardErrorWithdrawException("Broken Values");    
        }
    }
    
    private boolean enoughGrades(Double value, List<MoneyDto> listMoney){
        Double valueTemp = value;
        while(valueTemp > 0){
            boolean possible100 = valueTemp - 100 >= 0 ? true : false;
            if(possible100) {
                int valueTest = 0;
                for(MoneyDto moneyDto : listMoney){
                    if(moneyDto.getValueNote() == 100 && moneyDto.getQuantidade() > 0){
                        if(valueTest + 100 < valueTemp){
                            valueTemp-=100;
                            moneyDto.oneLess();
                        }
                    }
                }
            }    
        }
        while(valueTemp > 0){
            boolean possible50 = valueTemp - 50 >= 0 ? true : false;
            if(possible50) {
                int valueTest = 0;
                for(MoneyDto moneyDto : listMoney){
                    if(moneyDto.getValueNote() == 50 && moneyDto.getQuantidade() > 0){
                        if(valueTest + 50 < valueTemp){
                            valueTemp-=50;
                            moneyDto.oneLess();
                        }
                    }
                }
            }
        }
        while(valueTemp > 0){
            boolean possible20 = valueTemp - 20 >= 0 ? true : false;
            if(possible20) {
                int valueTest = 0;
                for(MoneyDto moneyDto : listMoney){
                    if(moneyDto.getValueNote() == 20 && moneyDto.getQuantidade() > 0){
                        if(valueTest + 20 < valueTemp){
                            valueTemp-=20;
                            moneyDto.oneLess();
                        }
                    }
                }
            }
        }
        while(valueTemp > 0){
            boolean possible10 = valueTemp - 10 >= 0 ? true : false;
            if(possible10) {
                int valueTest = 0;
                for(MoneyDto moneyDto : listMoney){
                    if(moneyDto.getValueNote() == 10 && moneyDto.getQuantidade() > 0){
                        if(valueTest + 10 < valueTemp){
                            valueTemp-=10;
                            moneyDto.oneLess();
                        }
                    }
                }
            }
        }
        while(valueTemp > 0){
            boolean possible5 = valueTemp - 10 >= 0 ? true : false;
            if(possible5) {
                int valueTest = 0;
                for(MoneyDto moneyDto : listMoney){
                    if(moneyDto.getValueNote() == 5 && moneyDto.getQuantidade() > 0){
                        if(valueTest + 5 < valueTemp){
                            valueTemp-=5;
                            moneyDto.oneLess();
                        }
                    }
                }
            }
        }
        while(valueTemp > 0){
            boolean possible2 = valueTemp - 2 >= 0 ? true : false;
            if(possible2) {
                int valueTest = 0;
                for(MoneyDto moneyDto : listMoney){
                    if(moneyDto.getValueNote() == 2 && moneyDto.getQuantidade() > 0){
                        if(valueTest + 2 < valueTemp){
                            valueTemp-=2;
                            moneyDto.oneLess();
                        }
                    }
                }
            }
        }
        
        if(valueTemp == 0){
            saveListMoneyDtoDataBase(listMoney);
            return true;
        } else {
            throw new StandardErrorWithdrawException("Insufficient Amount of Notes");
        }
    }

    private void saveListMoneyDtoDataBase(List<MoneyDto> listMoneyDto) {
        List<Money> listMoney = new ArrayList<>();
        for(MoneyDto money : listMoneyDto){
            listMoney.add(MoneyFactory.convertMoney(money));    
        }
        moneyService.saveAll(listMoney);
    }
}
