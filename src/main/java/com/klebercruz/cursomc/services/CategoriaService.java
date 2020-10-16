package com.klebercruz.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klebercruz.cursomc.domain.Categoria;
import com.klebercruz.cursomc.repositories.CategoriaRepository;
import com.klebercruz.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;

	public  Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() ->new ObjectNotFoundException("Objeto não encontrado! id: "
		+ id +" , Tipo: " + Categoria.class.getName()));
	}

}
