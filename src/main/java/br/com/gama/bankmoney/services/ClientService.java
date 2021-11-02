package br.com.gama.bankmoney.services;

import br.com.gama.bankmoney.controller.exception.ResourceNotFoundException;
import br.com.gama.bankmoney.dto.ClientDto;
import br.com.gama.bankmoney.entity.Client;
import br.com.gama.bankmoney.factory.ClientFactory;
import br.com.gama.bankmoney.form.ClientForm;
import br.com.gama.bankmoney.repository.AccountRepository;
import br.com.gama.bankmoney.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;
    
    @Autowired
    private AccountRepository accountRepository;
    
    public List<ClientDto> findAll(){
        List<Client> listCLient = clientRepository.findAll();
        List<ClientDto> listClientDto = new ArrayList<>();
        for(Client client: listCLient){
            listClientDto.add(ClientFactory.convertClientDto(client,accountRepository));
        }
        return listClientDto;
    }
    
    public ClientDto findById(Integer id){
        Optional<Client> clientOptional = clientRepository.findById(id);
        if(clientOptional.isEmpty()){
            throw new ResourceNotFoundException(id); 
        }
        Client client = clientOptional.get(); 
        return ClientFactory.convertClientDto(client,accountRepository);
    }
    
    public ClientDto saveClient(ClientForm clientForm){
        Client client = ClientFactory.convertCLient(clientForm);
        clientRepository.save(client);
        return ClientFactory.convertClientDto(client,accountRepository);
    }
}
