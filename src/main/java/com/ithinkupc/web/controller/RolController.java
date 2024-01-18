package com.ithinkupc.web.controller;

import com.ithinkupc.web.dto.RolDTO;
import com.ithinkupc.web.form.RolForm;
import com.ithinkupc.web.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/rol")
public class RolController {
    private final RolService rolService;

    @Autowired
    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public String rol(RolForm rolForm) {
        return "/rol/rol-buscar";
    }

    @GetMapping("/alta")
    public String rolAlta(RolForm rolForm) {
        return "/rol/rol-crud";
    }

    @GetMapping("/rol-buscar")
    public String rolBuscar(RolForm rolForm) {
        try {
            RolDTO rolDTO = rolForm.getRol();
            List<RolDTO> rolesDTO = rolService.findRoles(rolDTO);
            rolForm.setRoles(rolesDTO);
            return "/rol/rol-buscar";
        } catch (Exception e) {
            return "/rol/rol-buscar";
        }
    }
}
