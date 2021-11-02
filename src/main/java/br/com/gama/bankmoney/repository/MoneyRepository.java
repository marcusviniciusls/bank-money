package br.com.gama.bankmoney.repository;

import br.com.gama.bankmoney.entity.Money;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MoneyRepository extends JpaRepository<Money, Integer> {
}
