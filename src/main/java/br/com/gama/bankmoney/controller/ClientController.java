package br.com.gama.bankmoney.controller;

import br.com.gama.bankmoney.dto.ClientDto;
import br.com.gama.bankmoney.entity.Client;
import br.com.gama.bankmoney.form.ClientForm;
import br.com.gama.bankmoney.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("client")
public class ClientController {
    
    @Autowired
    private ClientService clientService;
    
    @GetMapping
    public ResponseEntity<List<ClientDto>> findAll(){
        return ResponseEntity.ok(clientService.findAll());
    }
    
    @GetMapping(value = "{id}")
    public ResponseEntity<ClientDto> findById(@PathVariable Integer id){
        ClientDto clientDto = clientService.findById(id);
        return ResponseEntity.ok(clientDto);
    }
    
    @PostMapping
    public ResponseEntity<ClientDto> saveClient(@RequestBody ClientForm clientForm, UriComponentsBuilder uriComponentsBuilder){
        ClientDto clientDto = clientService.saveClient(clientForm);
        URI uri = uriComponentsBuilder.path("/client/{id}").buildAndExpand(clientDto.getId()).toUri();
        return ResponseEntity.created(uri).body(clientDto);
    }
}
