package it.dedagroup.registroPresenze.service.impl;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dedagroup.registroPresenze.DTO.RequestLoginUtenteDTO;
import it.dedagroup.registroPresenze.model.ModalitaLavoro;
import it.dedagroup.registroPresenze.model.Utente;
import it.dedagroup.registroPresenze.service.model.UtenteService;
import it.dedagroup.registroPresenze.singleton.Singleton;

@Service
public class UtenteServiceImpl implements UtenteService{

	@Autowired
	AdminServiceImpl adminService;

	@Override
	public Utente login(RequestLoginUtenteDTO request) {
		return Singleton.getInstance().getUtenteByUsernameAndPassword(request.getUsername(), request.getPassword()).orElseThrow(() -> new RuntimeException("nessun utente con queste credenziali"));
	}

	@Override
	public void addPresenza(long idUtente, LocalDateTime dataOra, ModalitaLavoro modalita) {
		Utente utente=adminService.getUtenteById(idUtente);
		if(utente==null)  throw new RuntimeException("utente non trovato");
		if(dataOra.getDayOfWeek() == DayOfWeek.SATURDAY || dataOra.getDayOfWeek() == DayOfWeek.SUNDAY) {
			throw new RuntimeException("è possibile registrare la presenza SOLO nei giorni lavorativi");
		}
			Singleton.getInstance().addPresenza(utente, dataOra, modalita);
	}

	@Override
	public Map<LocalDateTime, ModalitaLavoro> getPresenzeByMonth(Month mese, long idUtente) {
		
		Utente utente = adminService.getUtenteById(idUtente);
        if (utente == null) throw new RuntimeException("utente non trovato");

	    Map<LocalDateTime, ModalitaLavoro> presenzeUtente = adminService.getPresenzeByUtente(utente);
        
        return presenzeUtente.entrySet()
                             .stream()
                             .filter(entry -> entry.getKey().getMonth() == mese)
                             .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
