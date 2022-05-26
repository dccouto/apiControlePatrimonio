package com.navita.patrimonio.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navita.patrimonio.entities.interfaces.Convertible;
import com.navita.patrimonio.exceptions.MarcaException;

public interface GenericService<T extends Convertible<DTO>, DTO, ID>{

	JpaRepository<T, ID> getRepository();


	default List<DTO> findAll() {
		List<T> list = getRepository().findAll();

		return list.stream().map(x -> x.convertToDto()).collect(Collectors.toList());
	}

	default DTO findById(ID id) {
		T result = getRepository().findById(id).orElseThrow(() -> new MarcaException("Não localizado."));
		return result.convertToDto();

	}

}
