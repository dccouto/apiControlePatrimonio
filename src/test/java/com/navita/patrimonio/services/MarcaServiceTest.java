package com.navita.patrimonio.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.navita.patrimonio.entities.Marca;
import com.navita.patrimonio.exceptions.MarcaException;
import com.navita.patrimonio.repository.MarcaRepository;

@SpringBootTest
class MarcaServiceTest {
	
	@MockBean
	MarcaRepository marcaRepository;
	
	@Autowired
	MarcaService marcaService;

	@Test
	void seExiteMarcaComOMesmoNomeCadastradaReturnMarcaException() {
		when(marcaRepository.existsByNomeIgnoreCase("teste")).thenThrow(new MarcaException("Marca já cadastrada."));
		
		assertThrows(MarcaException.class, () -> marcaRepository.existsByNomeIgnoreCase("teste"));
	}
	
	
	@Test
	void deveRetornarUmaMarcaComOsDadosAtualizados() throws Exception {
		Long idMarca = 1L;
		String nome = "Teste";
		Marca marca = new Marca(idMarca, nome);
		
		String nomeAtualizado = "nomeAtualizado";
		Marca marcaAtualizada = new Marca(idMarca, nomeAtualizado);
		
		Marca marcaATual;

		when(marcaRepository.findById(idMarca)).thenReturn(Optional.ofNullable(marca));
		when(marcaRepository.save(marca)).thenReturn(marcaAtualizada);
				
		assertEquals(marcaAtualizada, marcaService.atualizarMarca(marca.getIdMarca(), nomeAtualizado));
	}

}
