package com.navita.patrimonio.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.navita.patrimonio.dtos.MarcaDto;
import com.navita.patrimonio.entities.interfaces.Convertible;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Marcas")
public class Marca implements Convertible<MarcaDto> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_MARCA")
	private Long idMarca;
	
	
	@Column(name = "NOME")
	private String nome;


	@Override
	public MarcaDto convertToDto() {
		return new MarcaDto(idMarca, nome);
	}
	
	
}
