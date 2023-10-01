package it.dedagroup.registroPresenze.DTO;

import it.dedagroup.registroPresenze.model.ModalitaLavoro;
import it.dedagroup.registroPresenze.model.Occupazione;
import it.dedagroup.registroPresenze.model.Ruolo;

public class ResponseUtenteDTO {

	private long id;
	private String nome;
    private String cognome;
    private String username;
    private int eta;
    private Ruolo ruolo;
    private ModalitaLavoro modalitaLavoro;
    private Occupazione occupazione;
    
    public ResponseUtenteDTO() {}
    
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
    
    
}
