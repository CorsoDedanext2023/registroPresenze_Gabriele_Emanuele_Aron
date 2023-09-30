package it.dedagroup.registroPresenze.model;

public enum ModalitaLavoro {

	    CASA("Lavoro da casa"),
	    SEDE("Lavoro in sede"),
	    FERIE("Ferie");

	    private final String descrizione;

	    ModalitaLavoro(String descrizione) {
	        this.descrizione = descrizione;
	    }

	    public String getDescrizione() {
	        return descrizione;
	    }
	

}
