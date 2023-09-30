package it.dedagroup.registroPresenze.model;




public class Utente {
	private String nome;
	private String cognome;
	private int eta;
	private Ruolo ruolo;
	private RegistroPresenze registroPersonale;
	
	


	public Utente(String nome, String cognome, int eta, Ruolo ruolo, RegistroPresenze registroPersonale) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.ruolo = ruolo;
		this.registroPersonale = registroPersonale;
	}


	public RegistroPresenze getRegistroPersonale() {
		return registroPersonale;
	}


	public void setRegistroPersonale(RegistroPresenze registroPersonale) {
		this.registroPersonale = registroPersonale;
	}


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
	

	
	
	
}
