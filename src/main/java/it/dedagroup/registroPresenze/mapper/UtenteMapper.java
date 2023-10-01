package it.dedagroup.registroPresenze.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import it.dedagroup.registroPresenze.DTO.ResponseUtenteDTO;
import it.dedagroup.registroPresenze.model.Utente;

@Component
public class UtenteMapper {

public ResponseUtenteDTO toUtenteDTO(Utente u) {
ResponseUtenteDTO uDTO = new ResponseUtenteDTO();
uDTO.setId(u.getId());
uDTO.setNome(u.getNome());
uDTO.setCognome(u.getCognome());
uDTO.setUsername(u.getUsername());
uDTO.setEta(u.getEta());
uDTO.setRuolo(u.getRuolo());
uDTO.setOccupazione(u.getOccupazione());
return uDTO;
}

public List<ResponseUtenteDTO> toUtenteDTOList(List<Utente> utenti){
return utenti.stream().map(this::toUtenteDTO).collect(Collectors.toList());
}

public Utente toUtente(ResponseUtenteDTO uDTO) {
Utente u = new Utente();
u.setNome(uDTO.getNome());
u.setCognome(uDTO.getCognome());
u.setUsername(uDTO.getUsername());
u.setEta(uDTO.getEta());
u.setRuolo(uDTO.getRuolo());
u.setOccupazione(uDTO.getOccupazione());
return u;
}

public List<Utente> toUtenteList(List<ResponseUtenteDTO> utentiDTO){
return utentiDTO.stream().map(this::toUtente).collect(Collectors.toList());
}
}
