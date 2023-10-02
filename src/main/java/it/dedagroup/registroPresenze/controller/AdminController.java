package it.dedagroup.registroPresenze.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.dedagroup.registroPresenze.DTO.ResponseUtenteDTO;
import it.dedagroup.registroPresenze.facade.AdminFacade;

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
}
