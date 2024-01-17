package com.ithinkupc.web.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPersona")
    private Long id;

    @Column(name = "dni")
    private String dni;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "fecha_alta")
    private Instant fechaAlta;

    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    private PersonaDireccion personaDireccion;

}
