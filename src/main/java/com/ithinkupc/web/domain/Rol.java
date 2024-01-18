package com.ithinkupc.web.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRol")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @OneToOne(mappedBy = "rol", cascade = CascadeType.ALL, orphanRemoval = true)
    private RolPersona rolPersona;

}
