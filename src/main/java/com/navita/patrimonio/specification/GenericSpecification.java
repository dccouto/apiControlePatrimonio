package com.navita.patrimonio.specification;

import org.springframework.data.jpa.domain.Specification;

public interface GenericSpecification<T, DTO> {
	
	Specification<T> toSpec(DTO dto);

}
