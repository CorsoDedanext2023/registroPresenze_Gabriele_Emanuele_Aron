package it.dedagroup.registroPresenze.model;

import java.time.LocalDateTime;


public class Utente {
	private String nome;
	private String cognome;
	private int eta;
	private Ruolo ruolo;
	private Occupazione occupazione;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public int getEta() {
		return eta;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}
	public Ruolo getRuolo() {
		return ruolo;
	}
	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}
	public Occupazione getOccupazione() {
		return occupazione;
	}
	public void setOccupazione(Occupazione occupazione) {
		this.occupazione = occupazione;
	}
	
	
	
}
