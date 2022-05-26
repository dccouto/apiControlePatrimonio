package com.navita.patrimonio.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.navita.patrimonio.dtos.PatrimonioDto;
import com.navita.patrimonio.entities.Patrimonio;
import com.navita.patrimonio.repositories.PatrimonioRepository;
import com.navita.patrimonio.services.interfaces.PatrimonioInterface;

@Service
class PatrimonioService implements PatrimonioInterface {

	@Autowired
	private PatrimonioRepository patrimonioRepository;
	
	@Override
	public JpaRepository<Patrimonio, Long> getRepository() {
		return this.patrimonioRepository;
	}

	@Override
	public Patrimonio cadastrarPatrimonio(PatrimonioDto patrimonioTO) {

		Patrimonio patrimonio = new Patrimonio(patrimonioTO);

		gerarNumeroTombo(patrimonio);

		return patrimonioRepository.save(patrimonio);

	}

	
	private void gerarNumeroTombo(Patrimonio patrimonio) {

		int lastIndexOf = patrimonioRepository.findAll().size();

		if (lastIndexOf == BigDecimal.ZERO.intValue()) {
			patrimonio.setNumeroTombo(BigDecimal.ONE.longValue());

		} else {
			Long ultimoPatrimonio = patrimonioRepository.findByLastNumeroTombo();
			patrimonio.setNumeroTombo(++ultimoPatrimonio);
		}
	}


	@Override
	public Patrimonio buscarPatrimonioPorNumeroTombo(Long id) {

		return patrimonioRepository.findByNumeroTombo(id)
				.orElseThrow(() -> new NoSuchElementException("Não encontrado."));

	}



}
