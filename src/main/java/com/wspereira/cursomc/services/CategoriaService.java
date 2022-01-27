package com.wspereira.cursomc.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wspereira.cursomc.domain.Categoria;
import com.wspereira.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	
	
	@Autowired							// Instanciação automática pelo Spring
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id +
				", Tipo: " + Categoria.class.getName(), null));
	}
	
	
}
