package com.klebercruz.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klebercruz.cursomc.domain.Pagamento;

@Repository
public interface  PagamentoRepository extends JpaRepository<Pagamento, Integer>{

}
