package com.navita.patrimonio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navita.patrimonio.dtos.MarcaDto;
import com.navita.patrimonio.entities.Marca;
import com.navita.patrimonio.services.interfaces.MarcaInterface;

@RestController
@RequestMapping(value = "/api/marca")
public class MarcaController {

	@Autowired
	private MarcaInterface marcaService;

	@PostMapping("/cadastrar")
	public ResponseEntity<Object> cadastrarMarca(@RequestBody Marca marca) {
		return ResponseEntity.status(HttpStatus.CREATED).body(marcaService.cadastraMarca(marca));
	}

	@GetMapping
	public ResponseEntity<Object> listarMarcas() {
		return ResponseEntity.status(HttpStatus.OK).body(marcaService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> listarMarcaPorId(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(marcaService.findById(id));
	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Object> atualizarMarca(@PathVariable Long id, @RequestBody Marca nome) {
		return ResponseEntity.status(HttpStatus.OK).body(marcaService.atualizarMarca(id, nome.getNome()));
	}
	
	@PostMapping("/filtro")
	public ResponseEntity<Page<MarcaDto>> listarMarcaPorFiltro(@RequestBody MarcaDto filtro, Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(marcaService.findByFilter(filtro, pageable));
	}


}
