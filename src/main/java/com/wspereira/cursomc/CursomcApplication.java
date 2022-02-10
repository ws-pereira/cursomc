package com.wspereira.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wspereira.cursomc.domain.Categoria;
import com.wspereira.cursomc.domain.Cidade;
import com.wspereira.cursomc.domain.Cliente;
import com.wspereira.cursomc.domain.Endereco;
import com.wspereira.cursomc.domain.Estado;
import com.wspereira.cursomc.domain.Pagamento;
import com.wspereira.cursomc.domain.PagamentoComBoleto;
import com.wspereira.cursomc.domain.PagamentoComCartao;
import com.wspereira.cursomc.domain.Pedido;
import com.wspereira.cursomc.domain.Produto;
import com.wspereira.cursomc.domain.enums.EstadoPagamento;
import com.wspereira.cursomc.domain.enums.TipoCliente;
import com.wspereira.cursomc.repositories.CategoriaRepository;
import com.wspereira.cursomc.repositories.CidadeRepository;
import com.wspereira.cursomc.repositories.ClienteRepository;
import com.wspereira.cursomc.repositories.EnderecoRepository;
import com.wspereira.cursomc.repositories.EstadoRepository;
import com.wspereira.cursomc.repositories.PagamentoRepository;
import com.wspereira.cursomc.repositories.PedidoRepository;
import com.wspereira.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository; 
	@Autowired
	private ProdutoRepository produtoRepository; 
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
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
		
		Estado e1 = new Estado(null, "Rio de Janeiro");
		Estado e2 = new Estado(null, "Minas Gerais");
		Estado e3 = new Estado(null, "Espirito Santo");
		
		Cidade c1 = new Cidade(null, "Rio de Janeiro", e1);
		Cidade c2 = new Cidade(null, "Uberlândia", e2);
		Cidade c3 = new Cidade(null, "Vitória", e3);
		Cidade c4 = new Cidade(null, "Itaóca", e3);
		
		
		
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
		
		
		e1.getCidades().addAll(Arrays.asList(c1));
		e2.getCidades().addAll(Arrays.asList(c2));
		e3.getCidades().addAll(Arrays.asList(c3, c4));
		
		estadoRepository.saveAll(Arrays.asList(e1,e2,e3));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3,c4));

		Cliente cli1 = new Cliente(null, "Edilene Pereira", "lene@gmail.com", "12345678901", TipoCliente.PESSOAFISICA);
		Cliente cli2 = new Cliente(null, "Pedro Santana", "pedro@gmail.com", "2345678901", TipoCliente.PESSOAFISICA);
		Cliente cli3 = new Cliente(null, "Lucas Pereira", "lucas@gmail.com", "3456789012", TipoCliente.PESSOAFISICA);
		Cliente cli4 = new Cliente(null, "Mateus Santana", "mateus@gmail.com", "4567890123", TipoCliente.PESSOAFISICA);
		Cliente cli5 = new Cliente(null, "WEPLM Solution House", "weplmshouse@gmail.com", "1111122233000134", TipoCliente.PESSOAJURIDICA);
		
		cli1.getTelefones().addAll(Arrays.asList("123456789","234567890"));
		cli5.getTelefones().addAll(Arrays.asList("123456789"));
		
		Endereco end1 = new Endereco(null, "Rua da Rua", "7777", "Rua Longa", "12345-000", cli1, c1);
		Endereco end2 = new Endereco(null, "Rua das Flores", "77", "Jardim", "23456-111", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(end1, end2 ));
		
		clienteRepository.saveAll(Arrays.asList(cli1,cli2,cli3,cli4,cli5));
		enderecoRepository.saveAll(Arrays.asList(end1, end2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		
		Pedido pdd1 = new Pedido(null, sdf.parse("22-01-2022 15:30"), cli2, end2);
		Pedido pdd2 = new Pedido(null, sdf.parse("15-01-2022 10:30"), cli1, end1);
		Pedido pdd3 = new Pedido(null, sdf.parse("22-01-2022 15:30"), cli2, end2);
		
		Pagamento pgto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, pdd1, 6);
		
		pdd1.setPagamento(pgto1);
		pdd3.setPagamento(pgto1);
		
		Pagamento pgto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, pdd2, sdf.parse("18-01-2022 18:59"), null);
		
		pdd2.setPagamento(pgto2);

		
		cli1.getPedidos().addAll(Arrays.asList(pdd1,pdd3));

		pedidoRepository.saveAll(Arrays.asList(pdd1,pdd2,pdd3));
		pagamentoRepository.saveAll(Arrays.asList(pgto1,pgto2));
		
	}
	
	

}
