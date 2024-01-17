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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPersonaDireccion")
    private Long id;

    @OneToOne
    @JoinColumn(name = "idPersona")
    private Persona persona;

    @Column(name = "tipo_via")
    private String tipoVia;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "ciudad")
    private String ciudad;
}
