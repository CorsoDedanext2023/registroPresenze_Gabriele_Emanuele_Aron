package it.dedagroup.registroPresenze.singleton;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import it.dedagroup.registroPresenze.model.ModalitaLavoro;
import it.dedagroup.registroPresenze.model.Utente;

public class Singleton {
	
	private static final Singleton instance = new Singleton();
	
	private List<Utente> listaUtenti = new ArrayList<>();
	private Map<Utente, Map<LocalDateTime, ModalitaLavoro>> righePresenze = new HashMap<>();
	

    public static Singleton getInstance() {
        return instance;
    }

    public void addUtente(Utente utente) {
        listaUtenti.add(utente);
    }

    public void addPresenza(Utente utente, LocalDateTime dataOra, ModalitaLavoro modalita) {
        Map<LocalDateTime, ModalitaLavoro> presenza = righePresenze.getOrDefault(utente, new HashMap<>());
        presenza.put(dataOra, modalita);
        righePresenze.put(utente, presenza);
    }

    public List<Utente> getUtenti() {
        return listaUtenti;
    }

    public Optional<Utente> getUtenteById(long id) {
        return listaUtenti.stream()
                .filter(utente -> utente.getId() == id)
                .findFirst();
    }
    
    public Optional<Utente> getUtenteByUsername(String username) {
        return listaUtenti.stream()
                .filter(utente -> utente.getUsername().equals(username))
                .findFirst();
    }
    
    public Optional<Utente> getUtenteByUsernameAndPassword(String username, String password) {
        return listaUtenti.stream()
                .filter(utente -> utente.getUsername().equals(username) && utente.getPassword().equals(password))
                .findFirst();
    }
    
    public Map<Utente, Map<LocalDateTime, ModalitaLavoro>> findAll() {
        return righePresenze;
    }  
}
