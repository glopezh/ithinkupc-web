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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class PersonaServiceImpl implements PersonaService {
    private PersonaRepository personaRepository;
    private PersonaDireccionRepository personaDireccionRepository;

    public PersonaServiceImpl(PersonaRepository personaRepository, PersonaDireccionRepository personaDireccionRepository) {
        this.personaRepository = personaRepository;
        this.personaDireccionRepository = personaDireccionRepository;
    }

    @Override
    public List<PersonaDTO> findPersonas(PersonaDTO personaDTO) {
        String dni = personaDTO.getDni();
        String nombre = personaDTO.getNombre();
        String apellido = personaDTO.getApellido();

        List<Persona> personas = personaRepository.findPersonas(dni, nombre, apellido);
        List<PersonaDTO> personasDTO = new ArrayList<>();

        for (Persona persona : personas) {
            personaDTO = new PersonaDTO();
            BeanUtils.copyProperties(persona, personaDTO);
            personasDTO.add(personaDTO);
        }

        return personasDTO;
    }

    @Override
    public List<PersonaDireccionDTO> findDirecciones(PersonaDireccionDTO personaDireccionDTO) {

        Long persona = personaDireccionDTO.getPersona();
        String tipoVia = personaDireccionDTO.getTipoVia();
        String nombreVia = personaDireccionDTO.getNombreVia();
        String ciudad = personaDireccionDTO.getCiudad();

        List<PersonaDireccion> personasDirecciones = personaDireccionRepository.findDirecciones(persona,tipoVia, nombreVia, ciudad);
        List<PersonaDireccionDTO> personasDireccionesDTO = new ArrayList<>();

        for (PersonaDireccion personaDireccion : personasDirecciones) {
            personaDireccionDTO = new PersonaDireccionDTO();
            BeanUtils.copyProperties(personaDireccion, personaDireccionDTO);
            personasDireccionesDTO.add(personaDireccionDTO);
        }

        return personasDireccionesDTO;
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

    @Override
    @Transactional
    public PersonaDTO savePersonaConDireccion(PersonaDTO personaDTO, PersonaDireccionDTO personaDireccionDTO) {
        Long idPersona = personaDTO.getId();

        if (idPersona != null) {
            Persona persona = personaRepository.findById(idPersona).orElse(null);

            if (persona != null) {
                BeanUtils.copyProperties(personaDTO, persona);
                persona = personaRepository.save(persona);

                actualizarOGuardarDireccion(personaDireccionDTO, persona);
            }
        } else {
            Persona persona = new Persona();
            BeanUtils.copyProperties(personaDTO, persona);
            persona.setFechaAlta(Instant.now());
            persona = personaRepository.save(persona);

            actualizarOGuardarDireccion(personaDireccionDTO, persona);

            BeanUtils.copyProperties(persona, personaDTO);
        }

        return personaDTO;
    }
    private void actualizarOGuardarDireccion(PersonaDireccionDTO personaDireccionDTO, Persona persona) {
        Long idDireccion = personaDireccionDTO.getId();

        if (idDireccion != null) {

            PersonaDireccion personaDireccion = personaDireccionRepository.findById(idDireccion).orElse(null);

            if (personaDireccion != null) {
                BeanUtils.copyProperties(personaDireccionDTO, personaDireccion);
                personaDireccionRepository.save(personaDireccion);
            }
        } else {

            PersonaDireccion nuevaDireccion = new PersonaDireccion();
            BeanUtils.copyProperties(personaDireccionDTO, nuevaDireccion);
            nuevaDireccion.setPersona(persona);
            personaDireccionRepository.save(nuevaDireccion);
        }
    }

    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }

}

