package com.ithinkupc.web.repository;

import com.ithinkupc.web.domain.PersonaDireccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PersonaDireccionRepository extends JpaRepository<PersonaDireccion, Long> {

    @Query(value = "select  p.* from persona_direccion p " +
            "where p.tipo_via like %:tipo_via% " +
            "AND p.nombre like %:nombre% " +
            "AND p.ciudad like %:ciudad% "
            ,nativeQuery = true)
    List<PersonaDireccion> findDirecciones(String tipo_via, String nombre,String ciudad);
}
