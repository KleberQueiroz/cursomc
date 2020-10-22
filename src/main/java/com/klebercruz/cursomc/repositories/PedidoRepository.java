package com.klebercruz.cursomc.repositories;

 import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klebercruz.cursomc.domain.Pedido;

@Repository
public interface  PedidoRepository extends JpaRepository<Pedido, Integer>{

}
