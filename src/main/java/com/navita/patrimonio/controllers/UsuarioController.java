package com.navita.patrimonio.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navita.patrimonio.entities.Usuario;
import com.navita.patrimonio.services.UsuarioService;

@RestController
@RequestMapping(value="/api/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;

	@PostMapping("/cadastrar")
	public ResponseEntity<Object> cadastrarUsuario(@Valid @RequestBody Usuario usuario){
		try {
			usuarioService.cadastrarUsuario(usuario);
			return ResponseEntity.status(HttpStatus.CREATED).build();
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
