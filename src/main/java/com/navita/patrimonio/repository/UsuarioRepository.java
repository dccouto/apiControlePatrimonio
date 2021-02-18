package com.navita.patrimonio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navita.patrimonio.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findByEmail(String email);
}
