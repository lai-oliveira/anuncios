package com.calculadora.anuncio.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.calculadora.anuncio.model.Anuncio;
import com.calculadora.anuncio.model.AnuncioRelatorio;
import com.calculadora.anuncio.repository.AnuncioRepository;
import org.springframework.stereotype.Service;

@Service
public class AnuncioService {

	@Autowired
	private AnuncioRepository anuncioRepository;


	public Anuncio salvarAnuncios(Anuncio anuncio) {
		Anuncio anuncioSalvo = anuncioRepository.save(anuncio);

		return anuncioSalvo;

	}

	public List<Anuncio> obterAnuncios() {
		List<Anuncio> anuncios = anuncioRepository.findAll();
		return anuncios;
	}

	public AnuncioRelatorio gerarRelatorio(Long idAnuncio) {
		Optional<Anuncio> cadastros = anuncioRepository.findById(idAnuncio);
		BigDecimal valor = cadastros.get().getValor();

		int compartilha = 0;
		int visualizacaoOriginal = 0;
		int visualizacao = 0;
		int totalVisualizacao = 0;
		int totalCompartilha = 0;
		int totalAnuncio = 0;
		int totalCliques = 0;

		while (totalCompartilha <= 4) {
			int cliques = 0;

			if (compartilha == 0) {

				visualizacaoOriginal = obterVisualizacoes(valor);

				visualizacao = obterVisualizacoes(valor);
			}

			if (totalVisualizacao == 0) {

				cliques = obterCliques(visualizacaoOriginal);

			} else {

				cliques = obterCliques(visualizacao);
			}

			totalCliques = totalCliques + cliques;

			compartilha = obterCompartilhamento(cliques);
			totalCompartilha += compartilha;

			visualizacao = obterVisualizacoesPorCompartilhamento(compartilha);
			totalVisualizacao += obterVisualizacoesPorCompartilhamento(compartilha);

			if (totalCompartilha == 0 || totalCompartilha == 4) {

				break;
			}
		}

		totalAnuncio = totalVisualizacao + visualizacaoOriginal;

		System.out.println("Visualizações anuncio compartilhado  : " + totalVisualizacao);
		System.out.println("Visualizações de anuncio original: " + visualizacaoOriginal);
		System.out.println("Projeção aproximada de total de visualizações do anuncio : " + totalAnuncio);

		AnuncioRelatorio anuncioRelatorio = new AnuncioRelatorio();
		anuncioRelatorio.setTotalCliques(totalCliques);
		anuncioRelatorio.setTotalCompartilha(totalCompartilha);
		anuncioRelatorio.setTotalInvestido(valor);
		anuncioRelatorio.setTotalVisualizacao(totalAnuncio);

		return anuncioRelatorio;
	}

	/**
	 * Metodo que obtem quantidades de cliques atraves de visualizaçoes
	 *
	 * @param visualizacoes
	 * @return quantidades de cliques de acordo com visualizaçoes
	 */
	private static int obterCliques(int visualizacoes) {
		return (int) Math.round(visualizacoes * 0.12);
	}

	/**
	 * Metodo que calcula visualizacoes
	 *
	 * @param valor
	 * @return quantidade de anuncios de acordo com o valor investido
	 */
	private static int obterVisualizacoes(BigDecimal valor) {
		return (int) Math.round(Double.parseDouble(valor.multiply(new BigDecimal(30)).toString()));
	}

	/**
	 * Metodo que calcula os compartilhamentos atraves de cliques
	 *
	 * @param cliques
	 * @return quantidade de compartilhamento
	 */
	private static int obterCompartilhamento(int cliques) {
		return (int) Math.round(cliques * 0.15);
	}

	/**
	 * Metodo que obtem o numero de visualizacões por compartilhamentos
	 *
	 * @param compartilha
	 * @return quantidade de novas visualizacões atravez do compartilhamento
	 */

	private static int obterVisualizacoesPorCompartilhamento(int compartilha) {
		return compartilha * 40;
	}

	public Anuncio findById(Long id) {
		Optional<Anuncio> anuncioRetornado = anuncioRepository.findById(id);
		return anuncioRetornado.get();

	}

}
