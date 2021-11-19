package org.serratec.projetin.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.projetin.domain.Cliente;
import org.serratec.projetin.repository.ClienteRepository;
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
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository repositorio;
	
//		Cliente cliente1 = new Cliente(1, "Roberto", "Teixeira", "2112", "1312", "3232");
		

	
	@GetMapping("/ler")
	public List<Cliente> listar(){
		return repositorio.findAll();
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
			repositorio.save(cliente);
			return cliente;
		}
		return null;
	}

}
