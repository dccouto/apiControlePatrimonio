package com.navita.patrimonio.dtos;

import javax.validation.constraints.NotBlank;

import com.navita.patrimonio.entities.Marca;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatrimonioDto {

	@NotBlank
	private String nome;
	
	private String descricao;
	
	private Marca marca;

		
}
