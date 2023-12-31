package it.dedagroup.registroPresenze.facade;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dedagroup.registroPresenze.DTO.RequestLoginUtenteDTO;
import it.dedagroup.registroPresenze.DTO.ResponseUtenteDTO;
import it.dedagroup.registroPresenze.mapper.UtenteMapper;
import it.dedagroup.registroPresenze.model.Utente;
import jakarta.servlet.http.HttpSession;
import it.dedagroup.registroPresenze.model.ModalitaLavoro;
import it.dedagroup.registroPresenze.service.model.UtenteService;

@Service
public class UtenteFacade {
	
	@Autowired
	UtenteService serviceU;
	@Autowired
	UtenteMapper mapperU;
	@Autowired
    HttpSession httpSession;
	

	public ResponseUtenteDTO login(RequestLoginUtenteDTO request) {
        Utente utente = serviceU.login(request);
        httpSession.setAttribute("id", utente.getId());
        return mapperU.toUtenteDTO(utente);
    }

	
	public void addPresenza(LocalDateTime dataOra, ModalitaLavoro modalita) {
		long idUtente = (long) httpSession.getAttribute("id");
		serviceU.addPresenza(idUtente, dataOra, modalita);
	}
	
	public Map<LocalDateTime, ModalitaLavoro> getPresenzeByMonth(Month mese) {
		long idUtente = (long) httpSession.getAttribute("id");
		return serviceU.getPresenzeByMonth(mese, idUtente);
	}
}
