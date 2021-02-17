package com.navita.patrimonio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navita.patrimonio.entities.Marca;
import com.navita.patrimonio.exceptions.MarcaException;
import com.navita.patrimonio.repository.MarcaRepository;

@Service
public class MarcaService {
	
	@Autowired
	private MarcaRepository marcaRepository;

	public Marca cadastraMarca(Marca marca) throws Exception {

		try {
			verificaSeExiteMarcaComOMesmoNomeCadastrada(marca);
			return marcaRepository.save(marca);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		
	}

	private void verificaSeExiteMarcaComOMesmoNomeCadastrada(Marca marca) throws Exception {
		try {
			if(marcaRepository.existsByNomeIgnoreCase(marca.getNome()))
				throw new MarcaException("Marca já cadastrada.");
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

	public List<Marca> buscarMarcas() throws Exception {
		try {
			
			return marcaRepository.findAll();
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public Marca buscarMarcaPorId(Long id) throws Exception {
		try {
			return marcaRepository.findById(id).orElseThrow();
				
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public Marca atualizarMarca(Long id, String nome) throws Exception {
		try {
			return marcaRepository.findById(id)
					.map(marca -> {
						marca.setNome(nome);
						return marcaRepository.save(marca);
					})
					.orElseThrow(); 
							
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
