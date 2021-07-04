package com.calculadora.anuncio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class AnuncioRelatorio {

	@Id
	@GeneratedValue()
	private long id;
	private int totalVisualizacao;
	private int totalCompartilha;
	private BigDecimal totalInvestido;
	private int totalCliques;

	public AnuncioRelatorio() {

	}

	public AnuncioRelatorio(int totalVisualizacao, int totalCompartilha, BigDecimal totalInvestido, int totalCliques) {
		this.totalVisualizacao = totalVisualizacao;
		this.totalCliques = totalCliques;
		this.totalInvestido = totalInvestido;
		this.totalCliques = totalCliques;
	}

	public int getTotalVisualizacao() {
		return totalVisualizacao;
	}

	public void setTotalVisualizacao(int totalVisualizacao) {
		this.totalVisualizacao = totalVisualizacao;
	}

	public int getTotalCompartilha() {
		return totalCompartilha;
	}

	public void setTotalCompartilha(int totalCompartilha) {
		this.totalCompartilha = totalCompartilha;
	}

	public int getTotalCliques() {
		return totalCliques;
	}

	public void setTotalCliques(int totalCliques) {
		this.totalCliques = totalCliques;
	}

	public BigDecimal getTotalInvestido() {
		return totalInvestido;
	}

	public void setTotalInvestido(BigDecimal totalInvestido) {
		this.totalInvestido = totalInvestido;
	}
}