package com.wspereira.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wspereira.cursomc.domain.Categoria;
import com.wspereira.cursomc.domain.Produto;
import com.wspereira.cursomc.repositories.CategoriaRepository;
import com.wspereira.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository; 
	@Autowired
	private ProdutoRepository produtoRepository; 

	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Papelaria");
		
		Produto p1 = new Produto(null, "Notebook", 4500.00);
		Produto p2 = new Produto(null, "Cadeira", 150.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		Produto p4 = new Produto(null, "Impressora", 800.00);
		Produto p5 = new Produto(null, "Resma A4", 15.99);
		
		// Iniciando a criação de associações entre Categorais x Produtos
		cat1.getProdutos().addAll(Arrays.asList(p1,p3,p4));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		cat3.getProdutos().addAll(Arrays.asList(p4));
		
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		p4.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		
		
		// Salvando os dados
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
	}
	
	

}
