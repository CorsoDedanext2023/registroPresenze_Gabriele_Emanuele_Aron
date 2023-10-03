package it.dedagroup.registroPresenze.DTO;

import it.dedagroup.registroPresenze.model.ModalitaLavoro;

public class RequestPresenzeByIdAndModalitaLavoroDTO {
	private long idUtente;
	private ModalitaLavoro modalitaLavoro;
	
	public long getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(long idUtente) {
		this.idUtente = idUtente;
	}
	public ModalitaLavoro getModalitaLavoro() {
		return modalitaLavoro;
	}
	public void setModalitaLavoro(ModalitaLavoro modalitaLavoro) {
		this.modalitaLavoro = modalitaLavoro;
	}

}
