package it.dedagroup.registroPresenze.model;

import java.util.Objects;

import it.dedagroup.registroPresenze.DTO.RequestRegistrazioneUtenteDTO;

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
    private ModalitaLavoro modalitaLavoro;
    private Occupazione occupazione;

    public Utente() {
        this.id = ++idCounter;
    }

    public Utente(String nome, String cognome, String username, String password, String passwordRipetuta, int eta, Ruolo ruolo, ModalitaLavoro modalitaLavoro, Occupazione occupazione) {
        this.id = ++idCounter;
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.password = password;
        this.passwordRipetuta = passwordRipetuta;
        this.eta = eta;
        this.ruolo = ruolo;
        this.modalitaLavoro = modalitaLavoro;
        this.occupazione = occupazione;
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
    	this.modalitaLavoro = regUtenteDTO.getModalitaLavoro();
    	this.occupazione = regUtenteDTO.getOccupazione();
    }

    public long getId() {
        return id;
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

	@Override
	public int hashCode() {
		return Objects.hash(cognome, eta, id, nome, occupazione, ruolo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utente other = (Utente) obj;
		return Objects.equals(cognome, other.cognome) && eta == other.eta && id == other.id
				&& Objects.equals(nome, other.nome) && occupazione == other.occupazione && ruolo == other.ruolo;
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + ", ruolo=" + ruolo
				+ ", occupazione=" + occupazione + "]";
	}
    
}