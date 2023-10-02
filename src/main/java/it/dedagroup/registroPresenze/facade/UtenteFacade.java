package it.dedagroup.registroPresenze.facade;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dedagroup.registroPresenze.DTO.RequestLoginUtenteDTO;
import it.dedagroup.registroPresenze.DTO.ResponseUtenteDTO;
import it.dedagroup.registroPresenze.mapper.UtenteMapper;
import it.dedagroup.registroPresenze.model.ModalitaLavoro;
import it.dedagroup.registroPresenze.service.UtenteService;

@Service
public class UtenteFacade {
	
	@Autowired
	UtenteService serviceU;
	@Autowired
	UtenteMapper mapperU;
	
	
	
	public ResponseUtenteDTO login(RequestLoginUtenteDTO request) {
		return mapperU.toUtenteDTO(serviceU.login(request));
	}
	
	public void addPresenza(long idUtente, LocalDateTime dataOra, ModalitaLavoro modalita) {
	serviceU.addPresenza(idUtente, dataOra, modalita);
	}

}
