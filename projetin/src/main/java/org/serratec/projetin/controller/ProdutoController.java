package org.serratec.projetin.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.projetin.domain.Produto;
import org.serratec.projetin.repository.ProdutoRepository;
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
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepositorio;
	
	@GetMapping
	public List<Produto> listar(){
		return produtoRepositorio.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.FOUND)
	public Optional<Produto> lerPorId(@PathVariable long id) {
		if(produtoRepositorio.existsById(id)) {
			return produtoRepositorio.findById(id);
		}
		return null;
	}
	
	@PostMapping("/criar")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Produto criar(@Valid @RequestBody Produto produto) {
		return produtoRepositorio.save(produto);
	}
	
	@DeleteMapping("/{id}")
	public void deletar (@PathVariable long id) {
		produtoRepositorio.deleteById(id);
	}
	
	@PutMapping("/atualizar/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Produto atualizar(@PathVariable long id, @RequestBody Produto produto) {
		if(produtoRepositorio.existsById(id)) {
			produto.setId(id);
			produtoRepositorio.save(produto);
			return produto;
		}
		return null;
	}

}
