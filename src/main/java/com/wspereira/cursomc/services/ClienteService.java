package com.wspereira.cursomc.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wspereira.cursomc.domain.Categoria;
import com.wspereira.cursomc.domain.Cliente;
import com.wspereira.cursomc.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	
	
	@Autowired							// Instanciação automática pelo Spring
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id +
				", Tipo: " + Cliente.class.getName(), null));
	}
	
	
}
