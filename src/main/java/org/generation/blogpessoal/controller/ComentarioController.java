package org.generation.blogpessoal.controller;

import java.util.List;

import org.generation.blogpessoal.model.Comentario;
import org.generation.blogpessoal.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/comentarios") 
@CrossOrigin(origins = "*")
public class ComentarioController {
	
	@Autowired
	private ComentarioRepository repo;
	
	@GetMapping
	public ResponseEntity<List<Comentario>> getAlll(){
		return ResponseEntity.ok(repo.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Comentario> post(@RequestBody Comentario comentario){
		return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(comentario));
	}
	
	@DeleteMapping
	public void delete (@PathVariable Long id) {
		repo.deleteById(id);
	}

}
