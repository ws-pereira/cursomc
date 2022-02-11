package com.wspereira.cursomc.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ItemPedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Double desconto;
	private Integer quantiadade;
	private Double preco;
	
	@EmbeddedId
	private ItemPedidoPK id = new ItemPedidoPK();
	
	
	public ItemPedido() {
		
	}


	public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {
		super();
		id.setPedido(pedido);
		id.setProduto(produto);
		this.desconto = desconto;
		this.quantiadade = quantidade;
		this.preco = preco;
		
	}
	
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}
	
	public Double getDesconto() {
		return desconto;
	}


	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}


	public Integer getQuantiadade() {
		return quantiadade;
	}


	public void setQuantiadade(Integer quantiadade) {
		this.quantiadade = quantiadade;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}


	public ItemPedidoPK getId() {
		return id;
	}


	public void setId(ItemPedidoPK id) {
		this.id = id;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
