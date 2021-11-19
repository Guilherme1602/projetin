package org.serratec.projetin.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.projetin.domain.Cliente;
import org.serratec.projetin.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository repositorio;
	
//		Cliente cliente1 = new Cliente(1, "Roberto", "Teixeira", "2112", "1312", "3232");
	
	@GetMapping
//	public List<Cliente> listar(){
//		return repositorio.findAll();
//	}
	public ResponseEntity<List<Cliente>> listar(){
		try {
			List<Cliente> clientes = repositorio.findAll();
			return ResponseEntity.ok(clientes);
		}catch(HttpMessageConversionException e) {
			System.err.print("Ocorreu algum erro");
		}
		return null;
	}
	
	@GetMapping("/{id}")
	public Optional<Cliente> lerPorId(@PathVariable long id){
		if(repositorio.existsById(id)) {
			return repositorio.findById(id);
		}
		return null;
	}
	
	@PostMapping("/criar")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Cliente criar(@Valid @RequestBody Cliente cliente) {
		
		return repositorio.saveAndFlush(cliente);
	}
	//FUNCIONOU, é preciso deletar a tabela antiga no BD
	
	@DeleteMapping("/deletar/{id}")
	@ResponseStatus(code = HttpStatus.GONE)
	public void deletar(@PathVariable long id) {
		repositorio.deleteById(id);
	}
	
	@DeleteMapping("/deletar")
	public void deletarTudo(){
		repositorio.deleteAll();
	}
	
	@PutMapping("/atualizar/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Cliente atualizar(@PathVariable long id, @RequestBody Cliente cliente) {
		if(repositorio.existsById(id)) {
			cliente.setId(id);
			repositorio.save(cliente);
			return cliente;
		}
		return null;
	}

}
