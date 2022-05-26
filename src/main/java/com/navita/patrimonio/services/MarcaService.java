package com.navita.patrimonio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.navita.patrimonio.dtos.MarcaDto;
import com.navita.patrimonio.entities.Marca;
import com.navita.patrimonio.exceptions.MarcaException;
import com.navita.patrimonio.repositories.MarcaRepository;
import com.navita.patrimonio.services.interfaces.MarcaInterface;

@Service
class MarcaService implements MarcaInterface {

	@Autowired
	private MarcaRepository marcaRepository;

	@Override
	public MarcaDto cadastraMarca(Marca marca) {

		verificaSeExiteMarcaComOMesmoNomeCadastrada(marca);
		return marcaRepository.save(marca).convertToDto();
	}
	private void verificaSeExiteMarcaComOMesmoNomeCadastrada(Marca marca) {

		if (marcaRepository.existsByNomeIgnoreCase(marca.getNome()))
			throw new MarcaException("Marca já cadastrada.");
	}

	@Override
	public MarcaDto atualizarMarca(Long id, String nome) {

		return marcaRepository.findById(id).map(marca -> {
			marca.setNome(nome);
			return marcaRepository.save(marca).convertToDto();
		}).orElseThrow(() -> new MarcaException("Sem elementos na lista"));

	}

	@Override
	public JpaRepository<Marca, Long> getRepository() {
		return this.marcaRepository;
	}


}
