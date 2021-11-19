package org.serratec.projetin.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.projetin.domain.Categoria;
import org.serratec.projetin.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepositorio;
	
	@GetMapping
	public List<Categoria> listar(){
		return categoriaRepositorio.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.FOUND)
	public Optional<Categoria> lerPorId(@PathVariable long id) {
		if(categoriaRepositorio.existsById(id)) {
			return categoriaRepositorio.findById(id);
		}
		return null;
	}
	
	@PostMapping("/criar")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Categoria criar(@Valid @RequestBody Categoria categoria) {
		return categoriaRepositorio.save(categoria);
	}
	
	@DeleteMapping("/{id}")
	public void deletar (@PathVariable long id) {
		categoriaRepositorio.deleteById(id);
	}
	
	@PutMapping("/atualizar/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Categoria atualizar(@PathVariable long id, @RequestBody Categoria categoria) {
		if(categoriaRepositorio.existsById(id)) {
			categoria.setId(id);
			categoriaRepositorio.save(categoria);
			return categoria;
		}
		return null;
	}

}
