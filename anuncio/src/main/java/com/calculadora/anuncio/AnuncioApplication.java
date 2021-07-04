package com.calculadora.anuncio;

import com.calculadora.anuncio.model.Anuncio;
import com.calculadora.anuncio.model.Cliente;
import com.calculadora.anuncio.repository.AnuncioRepository;
import com.calculadora.anuncio.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class AnuncioApplication extends SpringBootServletInitializer {

	@Autowired
	private AnuncioRepository anuncioRepository;
	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(AnuncioApplication.class, args);
	}

	@PostConstruct
	public void listen() {
		cargaDeAnuncios();
	}

	private void cargaDeAnuncios() {

		Cliente cliente1 = new Cliente("Capgemini 1", "111111");
		Cliente cliente2 = new Cliente("Proway 2", "22222");
		Cliente cliente3 = new Cliente("Laisa 3", "333333");

		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente1);
		clientes.add(cliente2);
		clientes.add(cliente3);

		clienteRepository.saveAll(clientes);

		Anuncio anuncio1 = new Anuncio(cliente1, "Casa Brasil", new Date(), new Date(), new BigDecimal(3.33));

		Anuncio anuncio2 = new Anuncio(cliente2, "Roda da Vida", new Date(), new Date(), new BigDecimal(1.00));

		Anuncio anuncio3 = new Anuncio(cliente3, "investimento", new Date(), new Date(), new BigDecimal(20.00));

		List<Anuncio> meusAnuncios = new ArrayList<>();
		meusAnuncios.add(anuncio1);
		meusAnuncios.add(anuncio2);
		meusAnuncios.add(anuncio3);

		anuncioRepository.saveAll(meusAnuncios);
	}

}