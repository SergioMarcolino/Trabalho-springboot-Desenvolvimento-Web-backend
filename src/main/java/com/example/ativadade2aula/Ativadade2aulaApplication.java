package com.example.ativadade2aula;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ativadade2aula.models.Diretor;
import com.example.ativadade2aula.models.Filme;
import com.example.ativadade2aula.repository.DiretorRepository;
import com.example.ativadade2aula.repository.FilmeRepository;

@SpringBootApplication
public class Ativadade2aulaApplication {

	@Bean
	public CommandLineRunner init(
		@Autowired FilmeRepository filmeRepository, @Autowired DiretorRepository diretorRepository) {
		return args -> {

			System.out.println("*** INSERINDO Diretores ***");
			Diretor d1 = new Diretor(null,"Guilherme",null);
			d1 = diretorRepository.save(d1);

			Diretor d2 = new Diretor(null,"João",null);
			d2 = diretorRepository.save(d2);

			Diretor d3 = new Diretor(null,"Maria",null);
			d3 = diretorRepository.save(d3);

			
			System.out.println("*** INSERINDO Filmes ***");
			Filme f1 = new Filme(null,"sla1",1000,d1);
			f1 = filmeRepository.save(f1);

			Filme f2 = new Filme(null,"Slasher",2000,d2);
			f2 = filmeRepository.save(f2);

			Filme f3 = new Filme(null,"Devor",3000,d3);
			f3 = filmeRepository.save(f3);
			
			System.out.println("*** Filmes maiore que 1000 minutos ***");
			List<Filme> filmes = filmeRepository.findByduracaoGreaterThan(1000);
			System.out.println("*** Filmes Encontrados ****");
			filmes.stream().map(Filme::getTitulo).forEach(System.out::println);

			System.out.println("*** Filmes com duração menor ou igual a 2000 minutos ***");
			List<Filme> filmes2 = filmeRepository.findByduracaoLessThanEqual(2000);
			System.out.println("*** Filmes Encontrados ****");
			filmes2.stream().map(Filme::getTitulo).forEach(System.out::println);

			System.out.println("*** Filmes que começam com Dev ***");
			List<Filme> filmes3 = filmeRepository.findByTituloStartingWith("Dev");
			System.out.println("*** FilmesEncontrados ****");
			filmes3.stream().map(Filme::getTitulo).forEach(System.out::println);

			System.out.println("*** Diretores que começam com Jo ***");
			List<Diretor> diretores = diretorRepository.findByNomeStartingWith("Jo");
			System.out.println("*** Diretores Encontrados ****");
			diretores.stream().map(Diretor::getNome).forEach(System.out::println);


			System.out.println("*** Diretor com id 1 ***");

			Diretor diretor = diretorRepository.findDiretorFetchFilme(d1.getId());
			System.out.println("*** Diretor Encontrado ****");
			System.out.println(diretor.getNome() + "tem" + diretor.getFilmes());



			
		};
}

	public static void main(String[] args) {
		SpringApplication.run(Ativadade2aulaApplication.class, args);
	}

}
