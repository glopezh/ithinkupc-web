package com.ithinkupc.web.service;

import com.ithinkupc.web.dto.RolDTO;

import java.util.List;

public interface RolService {
    List<RolDTO> findRoles(RolDTO rolDTO);
}
