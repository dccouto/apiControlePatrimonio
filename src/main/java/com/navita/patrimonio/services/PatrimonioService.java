package com.navita.patrimonio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navita.patrimonio.entities.Patrimonio;
import com.navita.patrimonio.repository.PatrimonioRepository;

@Service
public class PatrimonioService {
	
	@Autowired
	PatrimonioRepository patrimonioRepository;

	public Patrimonio cadastrarPatrimonio(Patrimonio patrimonio) throws Exception {
		try {
			return patrimonioRepository.save(patrimonio);
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public List<Patrimonio> buscarPatrimonios() throws Exception {
		try {
			return patrimonioRepository.findAll();
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

}
