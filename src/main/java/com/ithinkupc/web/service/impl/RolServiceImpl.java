package com.ithinkupc.web.service.impl;

import com.ithinkupc.web.domain.Rol;
import com.ithinkupc.web.dto.RolDTO;
import com.ithinkupc.web.repository.RolRepository;
import com.ithinkupc.web.service.RolService;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class RolServiceImpl implements RolService {
    private RolRepository rolRepository;

    public RolServiceImpl(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public List<RolDTO> findRoles(RolDTO rolDTO) {
        String nombre = rolDTO.getNombre();

        List<Rol> roles = rolRepository.findRoles(nombre);
        List<RolDTO> rolesDTO = new ArrayList<>();

        for (Rol rol : roles) {
            rolDTO = new RolDTO();
            BeanUtils.copyProperties(rol, rolDTO);
            rolesDTO.add(rolDTO);
        }

        return rolesDTO;
    }

}

