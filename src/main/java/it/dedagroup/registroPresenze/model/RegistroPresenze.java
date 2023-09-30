package it.dedagroup.registroPresenze.model;


import java.util.List;


public class RegistroPresenze {
		private Utente utente;
		List<Data> registro;
		
		
		
		public RegistroPresenze(Utente utente, List<Data> registro) {
			super();
			this.utente = utente;
			this.registro = registro;
		}
		
		
		public Utente getUtente() {
			return utente;
		}
		public void setUtente(Utente utente) {
			this.utente = utente;
		}
		public List<Data> getRegistro() {
			return registro;
		}
		public void setRegistro(List<Data> registro) {
			this.registro = registro;
		}
		
		
		
		
}
