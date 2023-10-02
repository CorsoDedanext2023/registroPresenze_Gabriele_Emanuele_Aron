package it.dedagroup.registroPresenze.service.model;

import org.springframework.stereotype.Service;

import it.dedagroup.registroPresenze.DTO.RequestLoginUtenteDTO;
import it.dedagroup.registroPresenze.DTO.RequestRegistrazioneUtenteDTO;
import it.dedagroup.registroPresenze.model.Utente;

@Service
public interface UtenteService {
	
	public Utente registrazione(RequestRegistrazioneUtenteDTO request);
	public Utente login(RequestLoginUtenteDTO request);

}
