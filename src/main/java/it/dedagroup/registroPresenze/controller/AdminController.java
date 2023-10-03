package it.dedagroup.registroPresenze.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.dedagroup.registroPresenze.DTO.RequestGiorno;
import it.dedagroup.registroPresenze.DTO.RequestRegistrazioneUtenteDTO;
import it.dedagroup.registroPresenze.DTO.ResponseUtenteDTO;
import it.dedagroup.registroPresenze.facade.AdminFacade;
import it.dedagroup.registroPresenze.model.ModalitaLavoro;
import it.dedagroup.registroPresenze.model.Utente;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value="admin")
public class AdminController {

	@Autowired
	AdminFacade facadeA;
	@GetMapping("/utenti/all")
     public  ResponseEntity<List<ResponseUtenteDTO>> getUtenti(){
		return ResponseEntity.ok(facadeA.getUtenti());
	}
	
	@GetMapping("/utente/id/{id}")
	public ResponseEntity<ResponseUtenteDTO> getUtenteById(@PathVariable long id){
		return ResponseEntity.ok(facadeA.getUtenteById(id));
	}
	
	@GetMapping("utente/username/{username}")
	public ResponseEntity<ResponseUtenteDTO> getUtenteByUsername(@PathVariable String username){
		return ResponseEntity.ok(facadeA.getUtenteByUsername(username));
	}
	
	@GetMapping("utente/cognome/{cognome}")
	public ResponseEntity<ResponseUtenteDTO> getUtenteByCognome(@PathVariable String cognome){
		return ResponseEntity.ok(facadeA.getUtenteByUsername(cognome));
	}
	
	@PostMapping("/registrazione")
	public ResponseEntity<ResponseUtenteDTO> registrazione (@Valid @RequestBody RequestRegistrazioneUtenteDTO request) {
		return ResponseEntity.status(HttpStatus.CREATED).body(facadeA.registrazione(request));
	}
	
	@GetMapping("utente/allpresenze")
	public Map<Utente, Map<LocalDateTime, ModalitaLavoro>> findAll(){
		return facadeA.findAll();
	}
	
	@GetMapping("utente/allpresenze/ordered")
	public Map<Utente, Map<LocalDateTime, ModalitaLavoro>> findAllOrdered(){
		return facadeA.findAllOrdered();
	}
	
	@GetMapping("utente/presenze/idUtente/{idUtente}")
	public Map<LocalDateTime, ModalitaLavoro> getPresenzeByIdUtente(@PathVariable long idUtente) {
		return facadeA.getPresenzeByUtente(idUtente);
	}
	
	@GetMapping("utente/presenze/giorno")
	public Map<Utente, ModalitaLavoro> getAllPresenzeByGiorno(@RequestBody RequestGiorno giorno) {
		return facadeA.getAllPresenzeByGiorno(giorno);
	}
	
}
