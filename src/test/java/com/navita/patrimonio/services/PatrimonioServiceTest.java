package com.navita.patrimonio.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.navita.patrimonio.TO.PatrimonioTO;
import com.navita.patrimonio.entities.Marca;
import com.navita.patrimonio.entities.Patrimonio;
import com.navita.patrimonio.repository.PatrimonioRepository;

@SpringBootTest
class PatrimonioServiceTest {

	@MockBean
	PatrimonioRepository patrimonioRepository;
	
	@Autowired
	PatrimonioService patrimonioService;
	
	/*
	 * @Test void aoCadastrarNovoPatrimonioSistemaDeveGerarNumeroTomboUnico() throws
	 * Exception { PatrimonioTO patrimonioTO = new PatrimonioTO("Cadeira",
	 * "sala de reunião", new Marca(1L, null)); Patrimonio patrimonio = new
	 * Patrimonio(patrimonioTO); patrimonio.setNumeroTombo(2L);
	 * 
	 * when(patrimonioRepository.save(patrimonio)).thenReturn(patrimonio);
	 * when(patrimonioRepository.findAll()).thenReturn(List.of(patrimonio));
	 * when(patrimonioRepository.findByLastNumeroTombo()).thenReturn(1L);
	 * 
	 * assertEquals(patrimonio,
	 * patrimonioService.cadastrarPatrimonio(patrimonioTO));
	 * 
	 * }
	 */

}
