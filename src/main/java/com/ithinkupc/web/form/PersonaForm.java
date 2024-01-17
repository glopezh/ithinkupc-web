package com.ithinkupc.web.form;

import com.ithinkupc.web.dto.PersonaDTO;
import com.ithinkupc.web.dto.PersonaDireccionDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode
public class PersonaForm {
    private List<PersonaDTO> personas = new ArrayList<>();
    private PersonaDTO persona = new PersonaDTO();
    private PersonaDireccionDTO personaDireccion = new PersonaDireccionDTO();
}
