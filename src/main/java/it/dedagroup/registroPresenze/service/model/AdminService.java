package it.dedagroup.registroPresenze.service.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import it.dedagroup.registroPresenze.DTO.RequestGiornoDTO;
import it.dedagroup.registroPresenze.DTO.RequestRegistrazioneUtenteDTO;
import it.dedagroup.registroPresenze.model.ModalitaLavoro;
import it.dedagroup.registroPresenze.model.Utente;

@Service
public interface AdminService {
	public List<Utente> getUtenti();
	public Utente getUtenteById(long id) ;
	public Utente getUtenteByUsername(String username) ;
	public Utente registrazioneUtente(RequestRegistrazioneUtenteDTO request);
	public Map<LocalDateTime, ModalitaLavoro> getPresenzeByUtente(Utente utente);
	public Map<Utente, Map<LocalDateTime, ModalitaLavoro>> findAll();
	public Map<Utente, Map<LocalDateTime, ModalitaLavoro>> findAllOrdered();
	public Utente getUtenteByCognome(String cognome);
	public Map<Utente, ModalitaLavoro> getAllPresenzeByGiorno(RequestGiornoDTO giorno);
    public Map<Utente, Map<LocalDateTime, ModalitaLavoro>> getPresenzeByModalitaLavoro(ModalitaLavoro modalita);
    public Map<LocalDateTime, ModalitaLavoro> getPresenzeByIdAndModalitaLavoro(long idUtente, ModalitaLavoro modalita);
}
