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



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idMarca == null) ? 0 : idMarca.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Marca other = (Marca) obj;
		if (idMarca == null) {
			if (other.idMarca != null)
				return false;
		} else if (!idMarca.equals(other.idMarca))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}


	
	
}
