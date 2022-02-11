package com.wspereira.cursomc.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wspereira.cursomc.domain.Pedido;
import com.wspereira.cursomc.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	
	
	@Autowired							// Instanciação automática pelo Spring
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id +
				", Tipo: " + Pedido.class.getName(), null));
	}
	
	
}
