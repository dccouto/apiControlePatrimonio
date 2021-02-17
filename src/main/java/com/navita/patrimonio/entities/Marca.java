package com.navita.patrimonio.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Marcas")
public class Marca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_MARCA")
	private Long idMarca;
	
	
	@Column(name = "NOME")
	private String nome;

	
	public Marca() {
		
	}

	

	public Marca(Long idMarca, String nome) {
		this.idMarca = idMarca;
		this.nome = nome;
	}



	public Long getIdMarca() {
		return idMarca;
	}


	public void setIdMarca(Long idMarca) {
		this.idMarca = idMarca;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	
}
