package it.dedagroup.registroPresenze.service.impl;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import it.dedagroup.registroPresenze.DTO.RequestRegistrazioneUtenteDTO;
import it.dedagroup.registroPresenze.model.ModalitaLavoro;
import it.dedagroup.registroPresenze.model.Utente;
import it.dedagroup.registroPresenze.service.model.AdminService;
import it.dedagroup.registroPresenze.singleton.Singleton;

@Service
public class AdminServiceImpl  implements AdminService{

	@Override
	public List<Utente> getUtenti() {
		return Singleton.getInstance().getUtenti();
		
	}

	@Override
	public Utente getUtenteById(long id) {
		if(id<0) throw new RuntimeException("id non valido");
		Utente utente=Singleton.getInstance().getUtenteById(id).orElseThrow(()->new RuntimeException("utente non trovato"));
		return utente;
	}

	@Override
	public Utente getUtenteByUsername(String username) {
		if(username==null) throw new RuntimeException("username non valido");
		Utente utente=Singleton.getInstance().getUtenteByUsername(username).orElseThrow(()->new RuntimeException("utente non trovato"));
		return utente;
	}
	
	@Override
	public Utente registrazioneUtente(RequestRegistrazioneUtenteDTO request) {
		Utente existingUser = Singleton.getInstance().getUtenteByUsername(request.getUsername()).orElse(null);
		if(existingUser != null) {
			throw new RuntimeException("username gia in uso!");
		}
		if(!request.getPassword().equals(request.getPasswordRipetuta())) {
			throw new RuntimeException("le password non corrispondono");
		}
		
		Utente newUser = new Utente(request);
		Singleton.getInstance().addUtente(newUser);
		return newUser;
	}

	@Override
	public Map<Utente, Map<LocalDateTime, ModalitaLavoro>> findAll() {
		return Singleton.getInstance().findAll();
	}
	
	@Override
	public Map<LocalDateTime, ModalitaLavoro> getPresenzeByUtente(Utente utente) {
		return Singleton.getInstance().getPresenzeByUtente(utente);
	}
}
