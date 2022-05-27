package com.navita.patrimonio.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.navita.patrimonio.dtos.LoginDto;
import com.navita.patrimonio.dtos.TokenDto;
import com.navita.patrimonio.securities.TokenService;

@RestController
@RequestMapping(value = "/api/auth")
public class AutenticacaoController {
	
	//Essa classe não faz injeção de dependência automaticamente, será configurado no SecurityConfiguration
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginDto loginTO){
		try {
			UsernamePasswordAuthenticationToken dadosLogin = new UsernamePasswordAuthenticationToken(loginTO.getEmail(), loginTO.getSenha());
			Authentication authenticate = authManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authenticate);
			return ResponseEntity.ok(new TokenDto(token, "Bearer"));
			
		} catch (AuthenticationException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		

		
	}
}
