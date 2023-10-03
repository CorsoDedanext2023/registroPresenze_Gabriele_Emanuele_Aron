package it.dedagroup.registroPresenze.service.model;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Map;

import org.springframework.stereotype.Service;

import it.dedagroup.registroPresenze.DTO.RequestLoginUtenteDTO;
import it.dedagroup.registroPresenze.model.ModalitaLavoro;
import it.dedagroup.registroPresenze.model.Utente;

@Service
public interface UtenteService {
	
	
	public Utente login(RequestLoginUtenteDTO request);
	public void addPresenza(long idUtente, LocalDateTime dataOra, ModalitaLavoro modalita);
	public Map<LocalDateTime, ModalitaLavoro> getPresenzeByMonth(Month mese, long idUtente);
}
