package com.example.ativadade2aula.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Filme {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200, nullable = false)
    private String titulo;
    @Column(nullable = false)
    private Integer duracao;
    @ManyToOne
    @JoinColumn(name= "diretor_id") 
    private Diretor diretor;

    
    @Override
    public String toString() {
        return "Filme{id=" + id + ", titulo='" + titulo + "'}";
    }
}

