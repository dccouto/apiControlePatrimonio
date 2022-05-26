package com.navita.patrimonio.services.interfaces;

import com.navita.patrimonio.dtos.PatrimonioDto;
import com.navita.patrimonio.entities.Patrimonio;

public interface PatrimonioInterface extends GenericService<Patrimonio, PatrimonioDto, Long> {
	
	Patrimonio cadastrarPatrimonio(PatrimonioDto patrimonioTO);
	
	Patrimonio buscarPatrimonioPorNumeroTombo(Long id);

}
