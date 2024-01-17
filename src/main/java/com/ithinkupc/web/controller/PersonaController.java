package com.ithinkupc.web.controller;

import com.ithinkupc.web.domain.Persona;
import com.ithinkupc.web.dto.PersonaDTO;
import com.ithinkupc.web.form.PersonaForm;
import com.ithinkupc.web.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/persona")
public class PersonaController {
    private final PersonaService personaService;

    @Autowired
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public String persona(PersonaForm personaForm) {
        return "/persona/persona-buscar";
    }

    @GetMapping("/alta")
    public String personaAlta(PersonaForm personaForm) {
        return "/persona/persona-crud";
    }


    @PostMapping("/guardar")
    public String personaGuardar(PersonaForm personaForm) {
        PersonaDTO personaDTO = personaForm.getPersona();
        PersonaDTO personaDTOP =  personaService.savePersona(personaDTO);
        personaForm.setPersona(personaDTOP);
        return "/persona/persona-crud";
    }

    @GetMapping("/persona-buscar")
    public String personaBuscar(PersonaForm personaForm) {
        PersonaDTO personaDTO = personaForm.getPersona();
        List<PersonaDTO> personasDTO = personaService.findPersonas(personaDTO);
        personaForm.setPersonas(personasDTO);
        return "/persona/persona-buscar";
    }


    @GetMapping("/delete/{id}")
    public String deletePersona(@PathVariable("id") Long idPersona, PersonaForm personaForm) {
       personaService.deletePersona(idPersona);
       return "/persona/persona-buscar";
    }

    @GetMapping("/{id}")
    public String findPersona(@PathVariable("id") Long idPersona, PersonaForm personaForm) {
        PersonaDTO personaDTO = personaService.findPersona(idPersona);
        personaForm.setPersona(personaDTO);
        return "/persona/persona-crud";
    }


}
