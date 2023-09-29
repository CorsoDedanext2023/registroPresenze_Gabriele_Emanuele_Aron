package it.dedagroup.registroPresenze.singleton;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import it.dedagroup.registroPresenze.model.ModalitaLavoro;
import it.dedagroup.registroPresenze.model.Utente;

public class Singleton {
	List<Utente> listaUtenti;
	private Map<List<Utente>, Map<LocalDateTime, ModalitaLavoro>> righePresenze;
}
