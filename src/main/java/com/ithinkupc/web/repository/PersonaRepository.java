package com.ithinkupc.web.repository;

import com.ithinkupc.web.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    @Query(value = "select  p.* from persona p " +
            "where p.dni like %:dni% " +
            "AND p.nombre like %:nombre% " +
            "AND p.apellidO like %:apellido% "
            ,nativeQuery = true)
    List<Persona> findPersonas(String dni, String nombre, String apellido);
}
