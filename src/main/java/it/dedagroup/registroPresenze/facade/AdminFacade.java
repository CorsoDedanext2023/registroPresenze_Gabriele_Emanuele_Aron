package it.dedagroup.registroPresenze.facade;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dedagroup.registroPresenze.DTO.RequestGiorno;
import it.dedagroup.registroPresenze.DTO.RequestRegistrazioneUtenteDTO;
import it.dedagroup.registroPresenze.DTO.ResponseUtenteDTO;
import it.dedagroup.registroPresenze.mapper.UtenteMapper;
import it.dedagroup.registroPresenze.model.ModalitaLavoro;
import it.dedagroup.registroPresenze.model.Utente;
import it.dedagroup.registroPresenze.service.model.AdminService;

@Service
public class AdminFacade {

	@Autowired
	AdminService admin;
	@Autowired
	UtenteMapper mapperA;
	
	public List<ResponseUtenteDTO> getUtenti(){
		List<Utente> listaU=admin.getUtenti();
		return listaU.stream().map(mapperA::toUtenteDTO).toList();
	}
	
	public  ResponseUtenteDTO getUtenteById(long id) {
		return mapperA.toUtenteDTO(admin.getUtenteById(id));
	}
	
	public  ResponseUtenteDTO getUtenteByUsername(String username) {
		return mapperA.toUtenteDTO(admin.getUtenteByUsername(username));
	}
	
	public  ResponseUtenteDTO getUtenteByCognome(String cognome) {
		return mapperA.toUtenteDTO(admin.getUtenteByUsername(cognome));
	}
	
	public ResponseUtenteDTO registrazione(RequestRegistrazioneUtenteDTO request) {
		return mapperA.toUtenteDTO(admin.registrazioneUtente(request));
	}
	
	public Map<Utente, Map<LocalDateTime, ModalitaLavoro>> findAll(){
		return admin.findAll();
	}
	
	public Map<LocalDateTime, ModalitaLavoro> getPresenzeByUtente(long idUtente) {
		Utente utente=admin.getUtenteById(idUtente);
		return admin.getPresenzeByUtente(utente);
	}
	
	public Map<Utente, ModalitaLavoro> getAllPresenzeByGiorno(RequestGiorno giorno) {
		return admin.getAllPresenzeByGiorno(giorno);
	}
}
