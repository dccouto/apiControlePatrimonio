package com.navita.patrimonio.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.navita.patrimonio.TO.PatrimonioTO;

@Entity
@Table(name="Patrimonios")
public class Patrimonio {
	
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
	
	public Patrimonio() {
		
	}

	public Patrimonio(Long idPatrimonio, String nome, String descricao, Long numeroTombo, Marca marca) {
		this.idPatrimonio = idPatrimonio;
		this.nome = nome;
		this.descricao = descricao;
		this.numeroTombo = numeroTombo;
		this.marca = marca;
	}
	
	public Patrimonio(PatrimonioTO patrimonioTO) {
		this.nome = patrimonioTO.getNome();
		this.descricao = patrimonioTO.getDescricao();
		this.marca = patrimonioTO.getMarca();
	}

	public Long getIdPatrimonio() {
		return idPatrimonio;
	}

	public void setIdPatrimonio(Long idPatrimonio) {
		this.idPatrimonio = idPatrimonio;
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

	public Long getNumeroTombo() {
		return numeroTombo;
	}

	public void setNumeroTombo(Long numeroTombo) {
		this.numeroTombo = numeroTombo;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	

}
