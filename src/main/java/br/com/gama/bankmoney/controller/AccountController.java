package br.com.gama.bankmoney.controller;

import br.com.gama.bankmoney.services.AccountService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/current-account")
public class AccountController {
    
    @Autowired
    private AccountService accountService;
    
    @GetMapping("{id}/withdraw")
    public ResponseEntity witfdraw(@PathVariable Integer id){
        double value = 200.0;
        accountService.withdraw(id,value);
        return ResponseEntity.ok().build();
    }
}
