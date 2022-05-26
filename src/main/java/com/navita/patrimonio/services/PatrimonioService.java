package com.navita.patrimonio.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navita.patrimonio.dtos.PatrimonioTO;
import com.navita.patrimonio.entities.Patrimonio;
import com.navita.patrimonio.repositories.PatrimonioRepository;

@Service
public class PatrimonioService {

	@Autowired
	private PatrimonioRepository patrimonioRepository;

	public Patrimonio cadastrarPatrimonio(PatrimonioTO patrimonioTO) {

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

	public List<Patrimonio> buscarPatrimonios() {
		return patrimonioRepository.findAll();

	}

	public Patrimonio buscarPatrimonioPorId(Long id) {

		return patrimonioRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Não encontrado."));

	}

	public Patrimonio buscarPatrimonioPorNumeroTombo(Long id) {

		return patrimonioRepository.findByNumeroTombo(id)
				.orElseThrow(() -> new NoSuchElementException("Não encontrado."));

	}
}
