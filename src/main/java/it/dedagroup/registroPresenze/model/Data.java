package it.dedagroup.registroPresenze.model;

import java.time.LocalDateTime;

public class Data {
		private ModalitaLavoro modalita;
		private LocalDateTime data;
		
		
		
		
		
		public Data(ModalitaLavoro modalita, LocalDateTime data) {
			super();
			this.modalita = modalita;
			this.data = data;
		}
		
		public ModalitaLavoro getModalita() {
			return modalita;
		}
		public void setModalita(ModalitaLavoro modalita) {
			this.modalita = modalita;
		}
		public LocalDateTime getData() {
			return data;
		}
		public void setData(LocalDateTime data) {
			this.data = data;
		}
		
		
		
}
