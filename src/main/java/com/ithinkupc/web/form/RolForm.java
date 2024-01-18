package com.ithinkupc.web.form;

import com.ithinkupc.web.dto.RolDTO;
import com.ithinkupc.web.dto.RolPersonaDTO;
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
public class RolForm {
    private List<RolDTO> roles = new ArrayList<>();
    private RolDTO rol = new RolDTO();
    private RolPersonaDTO rolPersona =  new RolPersonaDTO();
}
