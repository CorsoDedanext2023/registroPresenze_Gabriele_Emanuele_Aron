package it.dedagroup.registroPresenze.model;

import java.util.Objects;

import it.dedagroup.registroPresenze.DTO.RequestRegistrazioneUtenteDTO;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class Utente {
    private static long idCounter = 0;

    private long id;
    private String nome;
    private String cognome;
    private String username;
    private String password;
    private String passwordRipetuta;
    private int eta;
    private Ruolo ruolo;
    private Occupazione occupazione;

    public Utente() {
        this.id = ++idCounter;
    }

    public Utente(RequestRegistrazioneUtenteDTO regUtenteDTO) {
    	this.id = ++idCounter;
    	this.nome = regUtenteDTO.getNome();
    	this.cognome = regUtenteDTO.getCognome();
    	this.username = regUtenteDTO.getUsername();
    	this.password = regUtenteDTO.getPassword();
    	this.passwordRipetuta = regUtenteDTO.getPasswordRipetuta();
    	this.eta = regUtenteDTO.getEta();
    	this.ruolo = regUtenteDTO.getRuolo();
    	this.occupazione = regUtenteDTO.getOccupazione();
    }
    
}

