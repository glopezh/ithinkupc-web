package com.ithinkupc.web.service;

import com.ithinkupc.web.domain.Persona;
import com.ithinkupc.web.dto.PersonaDTO;

import java.util.List;
import java.util.Set;

public interface PersonaService {
    List<PersonaDTO> findPersonas(PersonaDTO personaDTO);

    PersonaDTO findPersona(Long idPersona);

    void deletePersona(Long idPersona);

    PersonaDTO savePersona(PersonaDTO personaDTO);
}
