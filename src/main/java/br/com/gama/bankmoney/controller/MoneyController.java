package br.com.gama.bankmoney.controller;

import br.com.gama.bankmoney.services.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("money")
public class MoneyController {
    
    @Autowired
    private MoneyService moneyService;
    
    @GetMapping(value = "/value")
    public Integer valueBankTotal(){
        return moneyService.totalBankValue();
    }    
}
