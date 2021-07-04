package com.calculadora.anuncio.controller;

import com.calculadora.anuncio.model.Anuncio;
import com.calculadora.anuncio.model.AnuncioRelatorio;
import com.calculadora.anuncio.service.AnuncioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Api
@RestController
@RequestMapping(path = "/anuncios")
public class AnuncioController {

	private AnuncioService anuncioService;

	public AnuncioController(AnuncioService anuncioService) {

		this.anuncioService = anuncioService;

	}

	@ApiOperation("Cadastrar clientes,uma por vez.")
	@PostMapping
	public ResponseEntity<Anuncio> save(@RequestBody Anuncio anuncio) {
		anuncioService.salvarAnuncios(anuncio);
		return new ResponseEntity<>(anuncio, HttpStatus.OK);

	}

	@ApiOperation("Consulta Clientes, retornando todas em uma lista. ")
	@GetMapping
	public ResponseEntity<List<Anuncio>> getAll() {
		List<Anuncio> nomes = new ArrayList<>();
		nomes = anuncioService.obterAnuncios();
		return new ResponseEntity<>(nomes, HttpStatus.OK);
	}

	@ApiOperation("Consulta de clientes pelo ID.")
	@GetMapping(path = "/{id}")
	public ResponseEntity<Anuncio> getById(@PathVariable long id) {
		Anuncio anuncio;
		try {
			anuncio = anuncioService.findById(id);
			return new ResponseEntity<Anuncio>(anuncio, HttpStatus.OK);
		} catch (NoSuchElementException nsee) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(path = "/{idAnuncio}/relatorio")
	public ResponseEntity<AnuncioRelatorio> obterRelatorioAnuncio(@PathVariable Long idAnuncio) {
		AnuncioRelatorio anuncioRelatorio;
		try {
			anuncioRelatorio = anuncioService.gerarRelatorio(idAnuncio);
			return new ResponseEntity<AnuncioRelatorio>(anuncioRelatorio, HttpStatus.OK);
		} catch (NoSuchElementException nsee) {
			return new ResponseEntity<AnuncioRelatorio>(HttpStatus.NOT_FOUND);
		}
	}

}
