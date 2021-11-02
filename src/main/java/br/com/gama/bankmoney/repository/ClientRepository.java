package br.com.gama.bankmoney.repository;

import br.com.gama.bankmoney.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
