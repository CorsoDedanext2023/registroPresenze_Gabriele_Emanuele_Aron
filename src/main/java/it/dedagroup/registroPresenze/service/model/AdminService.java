package it.dedagroup.registroPresenze.service.model;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import it.dedagroup.registroPresenze.model.Utente;

@Service
public interface AdminService {
	public List<Utente> getUtenti();
	public Utente getUtenteById(long id) ;
	public Utente getUtenteByUsername(String username) ;
}
