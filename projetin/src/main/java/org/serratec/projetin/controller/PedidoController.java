package org.serratec.projetin.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.projetin.domain.Pedido;
import org.serratec.projetin.repository.PedidoRepository;
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
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepositorio;
	
	@GetMapping
	public List<Pedido> listar(){
		return pedidoRepositorio.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.FOUND)
	public Optional<Pedido> lerPorId(@PathVariable long id) {
		if(pedidoRepositorio.existsById(id)) {
			return pedidoRepositorio.findById(id);
		}
		return null;
	}
	
	@PostMapping("/criar")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Pedido criar(@Valid @RequestBody Pedido pedido) {
		return pedidoRepositorio.save(pedido);
	}
	
	@DeleteMapping("/{id}")
	public void deletar (@PathVariable long id) {
		pedidoRepositorio.deleteById(id);
	}
	
	@PutMapping("/atualizar/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Pedido atualizar(@PathVariable long id, @RequestBody Pedido pedido) {
		if(pedidoRepositorio.existsById(id)) {
			pedido.setId(id);
			pedidoRepositorio.save(pedido);
			return pedido;
		}
		return null;
	}


}
