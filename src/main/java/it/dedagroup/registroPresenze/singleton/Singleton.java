package it.dedagroup.registroPresenze.singleton;


import java.util.List;



import it.dedagroup.registroPresenze.model.Utente;

public class Singleton {
	List<Utente> listaUtenti;
	
	private static Singleton instance;
	
	
	
	private Singleton() {
	}


	public static Singleton getInstance() {
                if (instance == null) {
                    instance = new Singleton();
                }
                return instance;
    }
}
