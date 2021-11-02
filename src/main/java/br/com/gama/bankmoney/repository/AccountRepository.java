package br.com.gama.bankmoney.repository;

import br.com.gama.bankmoney.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query("SELECT c FROM Account c WHERE client.id = :id")
    List<Account> findByAccountPerClient(Integer id);
    
    @Query("SELECT c.balance FROM Account c WHERE client.id = :id")
    Double findByAccountBalance(Integer id);    
}
