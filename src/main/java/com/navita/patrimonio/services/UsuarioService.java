package com.navita.patrimonio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.navita.patrimonio.entities.Usuario;
import com.navita.patrimonio.exceptions.UsuarioException;
import com.navita.patrimonio.repositories.UsuarioRepository;
import com.navita.patrimonio.services.interfaces.UsuarioInterface;

@Service
class UsuarioService implements UsuarioInterface {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public void cadastrarUsuario(Usuario usuario) {

		verificaSeJaExisteEmailCadastrado(usuario);

		validaCamposObrigatorio(usuario);

		encriptarSenha(usuario);

		usuarioRepository.save(usuario);

	}

	private void encriptarSenha(Usuario usuario) {
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
	}

	private static void validaCamposObrigatorio(Usuario usuario) {
		if (usuario.getSenha().trim() == "" || usuario.getSenha() == null) {
			throw new UsuarioException("A senha não pode ser nula ou em banco");
		}

	}

	private void verificaSeJaExisteEmailCadastrado(Usuario usuario) {
		if (usuarioRepository.existsByEmail(usuario.getEmail())) {
			throw new UsuarioException("O e-mail já está cadastrado na nossa base de dados");
		}
	}

}
