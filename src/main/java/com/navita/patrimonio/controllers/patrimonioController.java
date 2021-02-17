package com.navita.patrimonio.controllers;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navita.patrimonio.TO.PatrimonioTO;
import com.navita.patrimonio.services.PatrimonioService;

@RestController
@RequestMapping("/api/patrimonio")
public class patrimonioController {
	
	@Autowired
	private PatrimonioService patrimonioService;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Object> cadastrarPatrimonio(@RequestBody @Valid PatrimonioTO patrimonioTO) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(patrimonioService.cadastrarPatrimonio(patrimonioTO));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<Object> buscarPatrimonios(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(patrimonioService.buscarPatrimonios());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Object> buscarPatrimonioPorId(@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(patrimonioService.buscarPatrimonioPorId(id));
		} catch (NoSuchElementException e) {
		
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); 
		
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping("/buscar/numero-tombo/{id}")
	public ResponseEntity<Object> buscarPatrimonioPorNumeroTombo(@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(patrimonioService.buscarPatrimonioPorNumeroTombo(id));
			
		} catch (NoSuchElementException e) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

}
