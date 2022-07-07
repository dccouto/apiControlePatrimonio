package com.navita.patrimonio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.navita.patrimonio.entities.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long>, JpaSpecificationExecutor<Marca>{

	boolean existsByNomeIgnoreCase(String nome);

}
