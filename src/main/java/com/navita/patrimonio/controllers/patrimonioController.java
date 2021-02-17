package com.navita.patrimonio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navita.patrimonio.entities.Patrimonio;
import com.navita.patrimonio.services.PatrimonioService;

@RestController
@RequestMapping("/api/patrimonio")
public class patrimonioController {
	
	@Autowired
	private PatrimonioService patrimonioService;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Object> cadastrarPatrimonio(@RequestBody Patrimonio patrimonio) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(patrimonioService.cadastrarPatrimonio(patrimonio));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping
	public ResponseEntity<Object> buscarPatrimonios(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(patrimonioService.buscarPatrimonios());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

}
