package it.dedagroup.registroPresenze.DTO;

import it.dedagroup.registroPresenze.model.ModalitaLavoro;
import it.dedagroup.registroPresenze.model.Occupazione;
import it.dedagroup.registroPresenze.model.Ruolo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RequestRegistrazioneUtenteDTO {
	
	@NotBlank
	private String nome;
	@NotBlank
	private String cognome;
	@Size(min = 3,
		  max = 10,
		  message = "lunghezza username errata(3-10")
	private String username;
	@Size(min = 6, 
		  max = 16,
		  message = "lunghezza password errata(6-16)")
	private String password;
	private String passwordRipetuta;
	@NotNull
	private int eta;
	@NotNull
	private Ruolo ruolo;
	private ModalitaLavoro modalitaLavoro;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordRipetuta() {
		return passwordRipetuta;
	}
	public void setPasswordRipetuta(String passwordRipetuta) {
		this.passwordRipetuta = passwordRipetuta;
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
	public ModalitaLavoro getModalitaLavoro() {
		return modalitaLavoro;
	}
	public void setModalitaLavoro(ModalitaLavoro modalitaLavoro) {
		this.modalitaLavoro = modalitaLavoro;
	}
	public Occupazione getOccupazione() {
		return occupazione;
	}
	public void setOccupazione(Occupazione occupazione) {
		this.occupazione = occupazione;
	}

}
