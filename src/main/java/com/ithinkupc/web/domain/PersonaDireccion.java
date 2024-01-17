package com.ithinkupc.web.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "persona_direccion")
public class PersonaDireccion {
    @Id
    @Column(name = "idPersonaDireccion")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPersona")
    private Persona idPersona;

    @Column(name = "tipo_via")
    private String tipoVia;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "ciudad")
    private String ciudad;
}
