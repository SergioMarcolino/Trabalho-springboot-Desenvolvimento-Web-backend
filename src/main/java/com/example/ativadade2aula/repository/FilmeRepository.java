package com.example.ativadade2aula.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ativadade2aula.models.Filme;



public interface  FilmeRepository extends JpaRepository<Filme, Long> {

    List<Filme> findByTituloStartingWith(String titulo); //titulo inicia com 
    List<Filme> findByduracaoLessThanEqual(Integer duracao); // retoena menor igual que 
    List<Filme> findByduracaoGreaterThan(Integer duracao); //retorna filme com duração maior que 
    
}
