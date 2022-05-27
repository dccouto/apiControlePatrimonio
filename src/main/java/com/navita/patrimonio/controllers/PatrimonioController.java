package com.navita.patrimonio.controllers;

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

import com.navita.patrimonio.dtos.PatrimonioDto;
import com.navita.patrimonio.services.interfaces.PatrimonioInterface;

@RestController
@RequestMapping("/api/patrimonio")
public class PatrimonioController {

	@Autowired
	private PatrimonioInterface patrimonioService;

	@PostMapping("/cadastrar")
	public ResponseEntity<Object> cadastrarPatrimonio(@RequestBody @Valid PatrimonioDto patrimonioDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(patrimonioService.cadastrarPatrimonio(patrimonioDto));
	}

	@GetMapping("/buscar")
	public ResponseEntity<Object> buscarPatrimonios() {
		return ResponseEntity.status(HttpStatus.OK).body(patrimonioService.findAll());
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<Object> buscarPatrimonioPorId(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(patrimonioService.findById(id));
	}

	@GetMapping("/buscar/numero-tombo/{id}")
	public ResponseEntity<Object> buscarPatrimonioPorNumeroTombo(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(patrimonioService.buscarPatrimonioPorNumeroTombo(id));

	}

}
