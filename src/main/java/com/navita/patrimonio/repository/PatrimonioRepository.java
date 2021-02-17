package com.navita.patrimonio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.navita.patrimonio.entities.Patrimonio;

@Repository
public interface PatrimonioRepository extends JpaRepository<Patrimonio, Long> {


	@Query(value = "SELECT MAX(p.numeroTombo) from Patrimonio p")
	Long findByLastNumeroTombo();

	Optional<Patrimonio> findByNumeroTombo(Long id);


}
