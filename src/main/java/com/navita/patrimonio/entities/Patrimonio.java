package com.navita.patrimonio.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.navita.patrimonio.dtos.PatrimonioDto;
import com.navita.patrimonio.entities.interfaces.Convertible;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Patrimonios")
public class Patrimonio implements Convertible<PatrimonioDto> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_PATRIMONIO")
	private Long idPatrimonio;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "DESCRICAO")
	private String descricao;
	
	@Column(name = "NUMERO_TOMBO")
	private Long numeroTombo;
	
	@ManyToOne
	@JoinColumn(name="FK_MARCA")
	private Marca marca;
	
	
	public Patrimonio(PatrimonioDto patrimonioTO) {
		this.nome = patrimonioTO.getNome();
		this.descricao = patrimonioTO.getDescricao();
		this.marca = patrimonioTO.getMarca();
	}



	@Override
	public PatrimonioDto convertToDto() {
		return new PatrimonioDto(nome, descricao, marca);
	}
	
	

}
