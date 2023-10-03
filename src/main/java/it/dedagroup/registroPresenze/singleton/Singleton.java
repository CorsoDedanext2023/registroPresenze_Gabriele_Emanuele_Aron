package it.dedagroup.registroPresenze.singleton;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

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
    
    public Optional<Utente> getUtenteByCognome(String cognome) {
        return listaUtenti.stream()
                .filter(utente -> utente.getCognome().equals(cognome))
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
    
    public Map<LocalDateTime, ModalitaLavoro> getPresenzeByUtente(Utente utente) {
        return righePresenze.getOrDefault(utente, new HashMap<>());
    }
    
    public Map<Utente, Map<LocalDateTime, ModalitaLavoro>> findAll() {
        return righePresenze;
    }
    
    public Map<Utente, Map<LocalDateTime, ModalitaLavoro>> findAllOrdered() {
        Map<Utente, Map<LocalDateTime, ModalitaLavoro>> orderedPresenze = new LinkedHashMap<>();

        for (Map.Entry<Utente, Map<LocalDateTime, ModalitaLavoro>> entry : righePresenze.entrySet()) {
            Utente utente = entry.getKey();
            Map<LocalDateTime, ModalitaLavoro> presenzeUtente = entry.getValue();
            Map<LocalDateTime, ModalitaLavoro> sortedPresenzeUtente = new TreeMap<>(presenzeUtente);
            orderedPresenze.put(utente, sortedPresenzeUtente);
        }

        return orderedPresenze;
    }

    
    public Map<Utente, ModalitaLavoro> getAllPresenzeByGiorno(LocalDate giorno) {
        Map<Utente, ModalitaLavoro> presenzeGiorno = new HashMap<>();

        for (Utente utente : listaUtenti) {
            Map<LocalDateTime, ModalitaLavoro> presenzeUtente = righePresenze.get(utente);
            if (presenzeUtente != null) {
                Optional<Map.Entry<LocalDateTime, ModalitaLavoro>> presenza = presenzeUtente.entrySet().stream()
                        .filter(entry -> entry.getKey().toLocalDate().equals(giorno))
                        .findFirst();

                presenza.ifPresent(entry -> presenzeGiorno.put(utente, entry.getValue()));
            }
        }

        return presenzeGiorno;
    }

    public Map<LocalDateTime, ModalitaLavoro> getPresenzeByIdAndModalitaLavoro(long idUtente, ModalitaLavoro modalita) {
        Optional<Utente> optionalUtente = getUtenteById(idUtente);
        if (!optionalUtente.isPresent()) {
            return new HashMap<>();
        }
        Utente utente = optionalUtente.get();
        Map<LocalDateTime, ModalitaLavoro> presenzeUtente = getPresenzeByUtente(utente);
        return presenzeUtente.entrySet().stream()
                             .filter(entry -> entry.getValue() == modalita)
                             .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<Utente, Map<LocalDateTime, ModalitaLavoro>> getPresenzeByModalitaLavoro(ModalitaLavoro modalita) {
        Map<Utente, Map<LocalDateTime, ModalitaLavoro>> presenzeFiltered = new HashMap<>();
        for (Map.Entry<Utente, Map<LocalDateTime, ModalitaLavoro>> entry : righePresenze.entrySet()) {
            Map<LocalDateTime, ModalitaLavoro> presenzeUtente = entry.getValue().entrySet().stream()
                                                                  .filter(innerEntry -> innerEntry.getValue() == modalita)
                                                                  .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            if (!presenzeUtente.isEmpty()) {
                presenzeFiltered.put(entry.getKey(), presenzeUtente);
            }
        }
        return presenzeFiltered;
    }

}
