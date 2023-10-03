package it.dedagroup.registroPresenze.controller;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.dedagroup.registroPresenze.DTO.RequestLoginUtenteDTO;
import it.dedagroup.registroPresenze.DTO.RequestRegistraPresenzaDTO;
import it.dedagroup.registroPresenze.DTO.ResponseUtenteDTO;
import it.dedagroup.registroPresenze.facade.UtenteFacade;
import it.dedagroup.registroPresenze.model.ModalitaLavoro;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@RestController()
@RequestMapping(value="utente")
public class UtenteController {
	
	@Autowired
	UtenteFacade facadeU;
//	@Autowired
//    HttpSession httpSession;
	
	
	@PostMapping("/login")
	public ResponseEntity<ResponseUtenteDTO> registrazione (@Valid @RequestBody RequestLoginUtenteDTO request) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(facadeU.login(request));
	}
	
//	@GetMapping("/get")
//	public String getUsername() {
//		return httpSession.getAttribute("id").toString();
//	}
	@PostMapping("/addPresenza")
	public ResponseEntity<String> addPresenza(@RequestBody RequestRegistraPresenzaDTO rDTO){
		facadeU.addPresenza(rDTO.getDataOra(), rDTO.getModalitaLavoro());
		return ResponseEntity.ok("presenza aggiunta");
	}
	@GetMapping("/getPresenzeByMonth")
	public ResponseEntity<Map<LocalDateTime, ModalitaLavoro>> getPresenzeByMonth (@RequestParam Month mese) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(facadeU.getPresenzeByMonth(mese));
	}
	
}
