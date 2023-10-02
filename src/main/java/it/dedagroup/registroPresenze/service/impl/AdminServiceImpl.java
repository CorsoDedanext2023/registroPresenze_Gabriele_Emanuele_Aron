package it.dedagroup.registroPresenze.service.impl;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

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
	
	

}
