package com.navita.patrimonio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.navita.patrimonio.entities.Usuario;
import com.navita.patrimonio.exceptions.UsuarioException;
import com.navita.patrimonio.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	public void cadastrarUsuario(Usuario usuario) {
		
		try {
			verificaSeJaExisteEmailCadastrado(usuario);
			
			validaCamposObrigatorio(usuario);
			
			encriptarSenha(usuario);
			
			usuarioRepository.save(usuario);
			
		} catch (Exception e) {
			throw new UsuarioException(e.getMessage());
		}
		
	}

	private void encriptarSenha(Usuario usuario) {
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
	}

	private void validaCamposObrigatorio(Usuario usuario) {
		if(usuario.getSenha().trim() == "" || usuario.getSenha() == null) {
			throw new UsuarioException("A senha não pode ser nula ou em banco");
		}
		
	}

	private void verificaSeJaExisteEmailCadastrado(Usuario usuario) {
		if(usuarioRepository.existsByEmail(usuario.getEmail())) {
			throw new UsuarioException("O e-mail já está cadastrado na nossa base de dados");
		}
	}

}
