package com.ithinkupc.web.controller;

import com.ithinkupc.web.domain.Persona;
import com.ithinkupc.web.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonaRestController {
    private final PersonaService personaService;

    @Autowired
    public PersonaRestController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping("/personas")
    public ResponseEntity<List<Persona>> getAllPrices() {
        List<Persona> allPrices = personaService.getAllPersonas();

        return new ResponseEntity<>(allPrices, HttpStatus.OK);
    }

}

