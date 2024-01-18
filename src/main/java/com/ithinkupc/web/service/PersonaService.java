package com.ithinkupc.web.service;

import com.ithinkupc.web.domain.Persona;
import com.ithinkupc.web.dto.PersonaDTO;
import com.ithinkupc.web.dto.PersonaDireccionDTO;

import java.util.List;
import java.util.Set;

public interface PersonaService {
    List<PersonaDTO> findPersonas(PersonaDTO personaDTO);

    List<PersonaDireccionDTO> findDirecciones(PersonaDireccionDTO personaDireccionDTO);

    PersonaDTO findPersona(Long idPersona);

    void deletePersona(Long idPersona);

    PersonaDTO savePersonaConDireccion(PersonaDTO personaDTO, PersonaDireccionDTO personaDireccionDTO);
}
