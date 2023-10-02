package it.dedagroup.registroPresenze.service.impl;

import org.springframework.stereotype.Service;

import it.dedagroup.registroPresenze.DTO.RequestLoginUtenteDTO;
import it.dedagroup.registroPresenze.DTO.RequestRegistrazioneUtenteDTO;
import it.dedagroup.registroPresenze.model.Utente;
import it.dedagroup.registroPresenze.service.model.UtenteService;
import it.dedagroup.registroPresenze.singleton.Singleton;

@Service
public class UtenteServiceImpl implements UtenteService{

	@Override
	public Utente registrazione(RequestRegistrazioneUtenteDTO request) {
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
	public Utente login(RequestLoginUtenteDTO request) {
		return Singleton.getInstance().getUtenteByUsernameAndPassword(request.getUsername(), request.getPassword()).orElseThrow(() -> new RuntimeException("nessun utente con queste credenziali"));
	}

	

}
