package com.navita.patrimonio.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navita.patrimonio.TO.PatrimonioTO;
import com.navita.patrimonio.entities.Patrimonio;
import com.navita.patrimonio.repository.PatrimonioRepository;

@Service
public class PatrimonioService {
	
	@Autowired
	PatrimonioRepository patrimonioRepository;

	public Patrimonio cadastrarPatrimonio(PatrimonioTO patrimonioTO) throws Exception {
		try {
			Patrimonio patrimonio = new Patrimonio(patrimonioTO);
			
			gerarNumeroTombo(patrimonio);
		
			return patrimonioRepository.save(patrimonio);
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	private void gerarNumeroTombo(Patrimonio patrimonio) {
		
		int lastIndexOf = patrimonioRepository.findAll().size();
		
		if(lastIndexOf == BigDecimal.ZERO.intValue()) {
			patrimonio.setNumeroTombo(BigDecimal.ONE.longValue());
			
		}else {
			Long ultimoPatrimonio = patrimonioRepository.findByLastNumeroTombo();
			patrimonio.setNumeroTombo(++ultimoPatrimonio);
		}
	}

	public List<Patrimonio> buscarPatrimonios() throws Exception {
		try {
			return patrimonioRepository.findAll();
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	public Patrimonio buscarPatrimonioPorId(Long id) throws Exception {
		try {
			return patrimonioRepository.findById(id).orElseThrow();
			
		
		}catch(NoSuchElementException e) {
			throw new NoSuchElementException("Não encontrado.");
		}
		catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public Patrimonio buscarPatrimonioPorNumeroTombo(Long id) throws Exception {
		try {
			return patrimonioRepository.findByNumeroTombo(id).orElseThrow();
			
		
		}catch(NoSuchElementException e) {
			throw new NoSuchElementException("Não encontrado.");
		}
		catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
