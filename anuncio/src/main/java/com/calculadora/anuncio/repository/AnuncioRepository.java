package com.calculadora.anuncio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.calculadora.anuncio.model.Anuncio;

@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {

}