package com.wspereira.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.wspereira.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento{
	private static final long serialVersionUID = 1L;
	
	
	private Date dtVencimento;
	private Date dtPagamento;
	
	public PagamentoComBoleto() {
		
	}

	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dtVencimento, Date dtPagamento) {
		super(id, estado, pedido);
		this.dtPagamento = dtPagamento;
		this.dtVencimento = dtVencimento;
	}

	public Date getDtVencimento() {
		return dtVencimento;
	}

	public void setDtVencimento(Date dtVencimento) {
		this.dtVencimento = dtVencimento;
	}

	public Date getDtPagamento() {
		return dtPagamento;
	}

	public void setDtPagamento(Date dtPagamento) {
		this.dtPagamento = dtPagamento;
	}
	
	
}
