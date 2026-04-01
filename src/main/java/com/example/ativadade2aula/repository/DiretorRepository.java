package com.example.ativadade2aula.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ativadade2aula.models.Diretor;

public interface DiretorRepository extends JpaRepository<Diretor, Long>{

        List<Diretor> findByNomeStartingWith(String nome); 
        
    @Query("SELECT d from Diretor d left join fetch d.filmes where d.id = :id")
    Diretor findDiretorFetchFilme(@Param("id")Long id);
}