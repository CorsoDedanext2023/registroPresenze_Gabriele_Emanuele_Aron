package it.dedagroup.registroPresenze.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.dedagroup.registroPresenze.DTO.RequestLoginUtenteDTO;
import it.dedagroup.registroPresenze.DTO.RequestRegistrazioneUtenteDTO;
import it.dedagroup.registroPresenze.DTO.ResponseUtenteDTO;
import it.dedagroup.registroPresenze.facade.UtenteFacade;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@RestController()
@RequestMapping(value="utente")
public class UtenteController {
	
	@Autowired
	UtenteFacade facadeU;
	@Autowired
    HttpSession httpSession;
	
	@PostMapping("/registrazione")
	public ResponseEntity<ResponseUtenteDTO> registrazione (@Valid @RequestBody RequestRegistrazioneUtenteDTO request) {
		return ResponseEntity.status(HttpStatus.CREATED).body(facadeU.registrazione(request));
	}
	
	@PostMapping("/login")
	public ResponseEntity<ResponseUtenteDTO> registrazione (@Valid @RequestBody RequestLoginUtenteDTO request) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(facadeU.login(request));
	}
	
	@GetMapping("/get")
	public String getUsername() {
		return (String) httpSession.getAttribute("username");
	}

}
