package com.navita.patrimonio.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navita.patrimonio.TO.LoginTO;
import com.navita.patrimonio.security.TokenService;

@RestController
@RequestMapping(value = "/api/auth")
public class AutenticacaoController {
	
	//Essa classe não faz injeção de dependência automaticamente, será configurado no SecurityConfiguration
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<?> autenticar(@RequestBody @Valid LoginTO loginTO){
		try {
			UsernamePasswordAuthenticationToken dadosLogin = new UsernamePasswordAuthenticationToken(loginTO.getEmail(), loginTO.getSenha());
			Authentication authenticate = authManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authenticate);
			System.out.println(token);
			return ResponseEntity.ok().build();
			
		} catch (AuthenticationException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		

		
	}
}
