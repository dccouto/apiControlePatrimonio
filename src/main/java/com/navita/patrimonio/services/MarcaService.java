package com.navita.patrimonio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navita.patrimonio.entities.Marca;
import com.navita.patrimonio.exceptions.MarcaException;
import com.navita.patrimonio.repositories.MarcaRepository;

@Service
public class MarcaService {

	@Autowired
	private MarcaRepository marcaRepository;

	public Marca cadastraMarca(Marca marca) {

		verificaSeExiteMarcaComOMesmoNomeCadastrada(marca);
		return marcaRepository.save(marca);
	}

	private void verificaSeExiteMarcaComOMesmoNomeCadastrada(Marca marca) {

		if (marcaRepository.existsByNomeIgnoreCase(marca.getNome()))
			throw new MarcaException("Marca já cadastrada.");
	}

	public List<Marca> buscarMarcas() {

		return marcaRepository.findAll();
	}

	public Marca buscarMarcaPorId(Long id) {

		return marcaRepository.findById(id).orElseThrow();

	}

	public Marca atualizarMarca(Long id, String nome) {

		return marcaRepository.findById(id).map(marca -> {
			marca.setNome(nome);
			return marcaRepository.save(marca);
		}).orElseThrow();

	}

}
