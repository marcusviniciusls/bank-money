package br.com.gama.bankmoney.repository;

import br.com.gama.bankmoney.entity.Historic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<Historic,Integer> {
}
