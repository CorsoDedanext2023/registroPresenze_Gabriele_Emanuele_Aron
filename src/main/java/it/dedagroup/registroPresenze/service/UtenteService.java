package it.dedagroup.registroPresenze.service;

import it.dedagroup.registroPresenze.model.Utente;

public interface UtenteService {
	
	Utente getUserById (int id);
	void saveUtente (Utente u);

}
