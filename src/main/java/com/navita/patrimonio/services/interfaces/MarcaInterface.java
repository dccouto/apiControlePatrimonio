package com.navita.patrimonio.services.interfaces;

import com.navita.patrimonio.dtos.MarcaDto;
import com.navita.patrimonio.entities.Marca;

public interface MarcaInterface extends GenericService<Marca, MarcaDto, Long> {
	
	MarcaDto cadastraMarca(Marca marca);
	
	MarcaDto atualizarMarca(Long id, String nome);
}
