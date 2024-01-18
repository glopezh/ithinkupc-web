package com.ithinkupc.web.service.impl;

import com.ithinkupc.web.domain.Persona;
import com.ithinkupc.web.domain.PersonaDireccion;
import com.ithinkupc.web.dto.PersonaDTO;
import com.ithinkupc.web.dto.PersonaDireccionDTO;
import com.ithinkupc.web.repository.PersonaDireccionRepository;
import com.ithinkupc.web.repository.PersonaRepository;
import com.ithinkupc.web.service.PersonaService;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class PersonaServiceImpl implements PersonaService {
    private PersonaRepository personaRepository;

    @Autowired
    public PersonaServiceImpl(PersonaRepository personaRepository){
        this.personaRepository = personaRepository;
    }

    @Override
    public List<PersonaDTO> findPersonas(PersonaDTO personaDTO) {
        String dni = personaDTO.getDni();
        String nombre = personaDTO.getNombre();
        String apellido = personaDTO.getApellido();

        List<Persona> personas = personaRepository.findPersonas(dni, nombre, apellido);
        List<PersonaDTO> personasDTO = new ArrayList<>();

        for(Persona persona : personas) {
            personaDTO = new PersonaDTO();
            BeanUtils.copyProperties(persona, personaDTO);
            personasDTO.add(personaDTO);
        }

        return personasDTO;
    }

    @Override
    public PersonaDTO findPersona(Long idPersona) {
        Persona persona = personaRepository.findById(idPersona).orElse(null);
        PersonaDTO personaDTO = new PersonaDTO();
        BeanUtils.copyProperties(persona, personaDTO);
        return personaDTO;
    }


    @Override
    public void deletePersona(Long idPersona) {
        personaRepository.deleteById(idPersona);
    }



    @Transactional
    public PersonaDTO savePersona(PersonaDTO personaDTO) {
        if (personaDTO.getId() != null) {
            Persona persona = personaRepository.findById(personaDTO.getId()).orElseThrow(() -> new EntityNotFoundException("Persona no encontrada"));
            updatePersonaFromDTO(persona, personaDTO);
        } else {
            Persona persona = new Persona();
            BeanUtils.copyProperties(personaDTO, persona);
            persona.setFechaAlta(Instant.now());

            if (personaDTO.getDireccionDTO() != null) {
                PersonaDireccionDTO direccionDTO = personaDTO.getDireccionDTO();
                PersonaDireccion personaDireccion = new PersonaDireccion();
                personaDireccion.setTipoVia(direccionDTO.getTipoVia());
                personaDireccion.setNombreVia(direccionDTO.getNombreVia());
                personaDireccion.setCiudad(direccionDTO.getCiudad());

                persona.setPersonaDireccion(personaDireccion);
            }

            persona = personaRepository.saveAndFlush(persona);
            BeanUtils.copyProperties(persona, personaDTO);
        }
        return personaDTO;
    }

    private void updatePersonaFromDTO(Persona persona, PersonaDTO personaDTO) {
        BeanUtils.copyProperties(personaDTO, persona);
        // Actualizar también PersonaDireccion si es necesario
        if (persona.getPersonaDireccion() != null && personaDTO.getDireccionDTO() != null) {
            PersonaDireccionDTO direccionDTO = personaDTO.getDireccionDTO();
            PersonaDireccion personaDireccion = persona.getPersonaDireccion();
            personaDireccion.setTipoVia(direccionDTO.getTipoVia());
            personaDireccion.setNombreVia(direccionDTO.getNombreVia());
            personaDireccion.setCiudad(direccionDTO.getCiudad());
        }
    }

}

