package org.generation.blogpessoal.service;

import java.util.Optional;

import org.generation.blogpessoal.model.Tema;
import org.generation.blogpessoal.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemaService {
	
	@Autowired
	private TemaRepository repo;
	
	public Optional<Tema> cadastrarTema(Tema tema){
		
		if(repo.findByDescricao(tema.getDescricao()).isPresent()) {
			return Optional.empty();
		}
		
		return Optional.of(repo.save(tema));
		
	}
	
public Optional<Tema> atualizarTema(Tema tema){
		
		if(repo.findByDescricao(tema.getDescricao()).isPresent()) {
			return Optional.empty();
		}
		
		return Optional.of(repo.save(tema));
		
	}

}
