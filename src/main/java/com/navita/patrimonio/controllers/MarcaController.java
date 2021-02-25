package com.navita.patrimonio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navita.patrimonio.entities.Marca;
import com.navita.patrimonio.services.MarcaService;

@RestController
@RequestMapping(value = "/api/marca")
public class MarcaController {

	@Autowired
	private MarcaService marcaService;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Object> cadastrarMarca(@RequestBody Marca marca) {
		try {
			return  ResponseEntity.status(HttpStatus.CREATED).body(marcaService.cadastraMarca(marca));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping
	public ResponseEntity<Object> listarMarcas(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(marcaService.buscarMarcas());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> listarMarcaPorId(@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(marcaService.buscarMarcaPorId(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Object> atualizarMarca(@PathVariable Long id, @RequestBody Marca nome){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(marcaService.atualizarMarca(id, nome.getNome()));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
}









