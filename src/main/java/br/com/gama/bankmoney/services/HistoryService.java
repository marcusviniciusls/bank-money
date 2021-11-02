package br.com.gama.bankmoney.services;

import br.com.gama.bankmoney.entity.Historic;
import br.com.gama.bankmoney.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {
    
    @Autowired
    private HistoryRepository historyRepository;
    
    public void save(Historic historic){
        historyRepository.save(historic);
    } 
}
