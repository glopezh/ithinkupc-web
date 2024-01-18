package com.ithinkupc.web.form;

import com.ithinkupc.web.dto.PersonaDTO;
import com.ithinkupc.web.dto.PersonaDireccionDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Data
@EqualsAndHashCode
public class PersonaForm {
    private List<PersonaDTO> personas = new ArrayList<>();
    private PersonaDTO persona = new PersonaDTO();
    private PersonaDireccionDTO personaDireccion =  new PersonaDireccionDTO();
}
