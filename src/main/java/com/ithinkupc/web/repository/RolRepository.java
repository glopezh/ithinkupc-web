package com.ithinkupc.web.repository;

import com.ithinkupc.web.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

    @Query(value = "select  r.* from rol r " +
            "where r.nombre like %:nombre% "
            ,nativeQuery = true)
    List<Rol> findRoles(String nombre);
}
