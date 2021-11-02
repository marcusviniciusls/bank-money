package br.com.gama.bankmoney.config;

import br.com.gama.bankmoney.entity.Account;
import br.com.gama.bankmoney.entity.Client;
import br.com.gama.bankmoney.entity.Money;
import br.com.gama.bankmoney.entity.enums.Note;
import br.com.gama.bankmoney.repository.AccountRepository;
import br.com.gama.bankmoney.repository.ClientRepository;
import br.com.gama.bankmoney.repository.MoneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    
    @Autowired
    private ClientRepository clientRepository;
    
    @Autowired
    private AccountRepository accountRepository;
    
    @Autowired
    private MoneyRepository moneyRepository;
    
    @Override
    public void run(String... args) throws Exception {
        Client client = new Client("Marcus Vinicius","2432431","13219739821731","marcus@gmail.com");
        Client client1 = new Client("Vitoria","4534543","423","vitoria@gmail.com");
        Client client2 = new Client("Emily","54543","23432","emily@gmail.com");
        Client client3 = new Client("Antonio","3242","34324231312","antonio@gmail.com");
        Client client4 = new Client("Gracilane","423423","34131232","gracilane@gmail.com");

        Account account = new Account(new BigDecimal("200.0"),1234,"7908", client);
        Account account1 = new Account(new BigDecimal("140.0"),9876,"6534", client1);
        Account account2 = new Account(new BigDecimal("500.0"),2321,"7642", client2);
        Account account3 = new Account(new BigDecimal("700.0"),54322,"6553", client3);
        Account account4 = new Account(new BigDecimal("300.0"),2134,"8743", client4);

        client.addAccount(account);
        client1.addAccount(account1);
        client2.addAccount(account2);
        client3.addAccount(account3);
        client4.addAccount(account4);

        clientRepository.saveAll(Arrays.asList(client,client1,client2,client3,client4));
        accountRepository.saveAll(Arrays.asList(account,account1,account2,account3,account4));

        Money money = new Money(5, Note.DOIS);
        Money money1 = new Money(5, Note.CINCO);
        Money money2 = new Money(5, Note.DEZ);
        Money money3 = new Money(5, Note.VINTE);
        Money money4 = new Money(5, Note.CINQUENTA);
        Money money5 = new Money(5, Note.CEM);
        
        moneyRepository.saveAll(Arrays.asList(money,money1,money2,money3,money4,money5));
    }
}
