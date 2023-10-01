package it.dedagroup.registroPresenze.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dedagroup.registroPresenze.DTO.RequestLoginUtenteDTO;
import it.dedagroup.registroPresenze.DTO.RequestRegistrazioneUtenteDTO;
import it.dedagroup.registroPresenze.DTO.ResponseUtenteDTO;
import it.dedagroup.registroPresenze.mapper.UtenteMapper;
import it.dedagroup.registroPresenze.service.model.UtenteService;

@Service
public class UtenteFacade {
	
	@Autowired
	UtenteService serviceU;
	@Autowired
	UtenteMapper mapperU;
	
	public ResponseUtenteDTO registrazione(RequestRegistrazioneUtenteDTO request) {
		return mapperU.toUtenteDTO(serviceU.registrazione(request));
	}
	
	public ResponseUtenteDTO login(RequestLoginUtenteDTO request) {
		return mapperU.toUtenteDTO(serviceU.login(request));
	}

}
