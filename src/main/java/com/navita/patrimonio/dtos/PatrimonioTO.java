package com.navita.patrimonio.dtos;

import javax.validation.constraints.NotBlank;

import com.navita.patrimonio.entities.Marca;

public class PatrimonioTO {

	@NotBlank
	private String nome;
	
	private String descricao;
	
	
	private Marca marca;

	public PatrimonioTO(String nome, String descricao, Marca marca) {
		this.nome = nome;
		this.descricao = descricao;
		this.marca = marca;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	
}
