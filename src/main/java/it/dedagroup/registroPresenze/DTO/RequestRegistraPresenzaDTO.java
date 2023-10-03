package it.dedagroup.registroPresenze.DTO;

import java.time.LocalDateTime;

import it.dedagroup.registroPresenze.model.ModalitaLavoro;

public class RequestRegistraPresenzaDTO {
	
	private LocalDateTime dataOra;
	private ModalitaLavoro modalitaLavoro;
	
	public LocalDateTime getDataOra() {
		return dataOra;
	}
	public void setDataOra(LocalDateTime dataOra) {
		this.dataOra = dataOra;
	}
	public ModalitaLavoro getModalitaLavoro() {
		return modalitaLavoro;
	}
	public void setModalitaLavoro(ModalitaLavoro modalitaLavoro) {
		this.modalitaLavoro = modalitaLavoro;
	}
	
	

}
