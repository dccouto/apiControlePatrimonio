package com.navita.patrimonio.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.navita.patrimonio.dtos.MarcaDto;
import com.navita.patrimonio.entities.Marca;
import com.navita.patrimonio.entities.Marca_;

@Component
public class MarcaSpecification implements GenericSpecification<Marca, MarcaDto> {

	private static final String PERCENT = "%";

	@Override
	public Specification<Marca> toSpec(MarcaDto dto) {
		List<Predicate> predicates = new ArrayList<>();
		
		return (root, query, criteriaBuilder) -> {
			if (dto.getIdMarca() != null) {
				Path<Long> fieldName = root.get(Marca_.ID_MARCA);
				Predicate predicateId = criteriaBuilder.equal(fieldName, dto.getIdMarca());
				predicates.add(predicateId);
			}
			if(StringUtils.hasText(dto.getNome())) {
				Path<String> fieldName = root.get(Marca_.NOME);
				Predicate predicateNome = criteriaBuilder.like(fieldName, PERCENT + dto.getNome() + PERCENT);
				predicates.add(predicateNome);
			}
			
			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
		};
		
	}

}
