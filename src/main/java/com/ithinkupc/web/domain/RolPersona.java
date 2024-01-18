package com.ithinkupc.web.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "rol_persona")
public class RolPersona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRolPersona")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPersona")
    private Persona persona;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idRol")
    private Rol rol;
}
