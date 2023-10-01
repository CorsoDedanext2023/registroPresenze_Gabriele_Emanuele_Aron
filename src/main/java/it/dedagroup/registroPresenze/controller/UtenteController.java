package it.dedagroup.registroPresenze.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.dedagroup.registroPresenze.DTO.RequestRegistrazioneUtenteDTO;
import it.dedagroup.registroPresenze.DTO.ResponseUtenteDTO;
import it.dedagroup.registroPresenze.facade.UtenteFacade;
import jakarta.validation.Valid;

@RestController()
public class UtenteController {
	
	@Autowired
	UtenteFacade facadeU;
	
	@PostMapping("/registrazione")
	public ResponseEntity<ResponseUtenteDTO> registrazione (@Valid @RequestBody RequestRegistrazioneUtenteDTO request) {
		return ResponseEntity.status(HttpStatus.CREATED).body(facadeU.registrazione(request));
	}

}
