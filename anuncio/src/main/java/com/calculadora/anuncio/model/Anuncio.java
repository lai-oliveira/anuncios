package com.calculadora.anuncio.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Anuncio {

	@Id
	@GeneratedValue()
	private Long id;

	@ManyToOne
	@JoinColumn(name = "clienteId")
	private Cliente cliente;
	private String nomeAnuncio;
	private Date inicio;
	private Date termino;
	private BigDecimal valor;
    
	public Anuncio() {
	}

	public Anuncio(Cliente cliente, String nomeAnuncio, Date inicio, Date termino, BigDecimal valor) {
		this.cliente = cliente;
		this.nomeAnuncio = nomeAnuncio;
		this.inicio = inicio;
		this.termino = termino;
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNomeAnuncio() {
		return nomeAnuncio;
	}

	public void setNomeAnuncio(String nomeAnuncio) {
		this.nomeAnuncio = nomeAnuncio;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getTermino() {
		return termino;
	}

	public void setTermino(Date termino) {
		this.termino = termino;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	

}