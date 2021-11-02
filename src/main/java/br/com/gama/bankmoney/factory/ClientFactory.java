package br.com.gama.bankmoney.factory;

import br.com.gama.bankmoney.dto.ClientDto;
import br.com.gama.bankmoney.entity.Account;
import br.com.gama.bankmoney.entity.Client;
import br.com.gama.bankmoney.form.ClientForm;
import br.com.gama.bankmoney.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ClientFactory {
    
    public static ClientDto convertClientDto(Client client, AccountRepository accountRepository){
        ClientDto clientDto = new ClientDto();
        clientDto.setCpf(client.getCpf());
        clientDto.setEmail(client.getEmail());
        clientDto.setName(client.getName());
        clientDto.setTelephone(client.getTelephone());
        clientDto.setId(client.getId());
        clientDto.setListAccount(findByAccountByClient(client, accountRepository));
        
        return clientDto;
    }
    
    private static List<Account> findByAccountByClient(Client client, AccountRepository accountRepository){
        List<Account> listAccount = new ArrayList<>();
        listAccount = accountRepository.findByAccountPerClient(client.getId());
        return listAccount;
    }
    
    public static Client convertCLient(ClientForm clientForm){
        Client client = new Client();
        client.setCpf(clientForm.getCpf());
        client.setEmail(clientForm.getEmail());
        client.setName(clientForm.getName());
        client.setTelephone(clientForm.getTelephone());
        
        return client;
    }
}
