package com.ithinkupc.web.dto;
import lombok.*;

@ToString
@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
@EqualsAndHashCode(of={"id"})
public class PersonaDTO {
    private Long id;
    private String dni;
    private String nombre;
    private String apellido;
    private String telefono;
    private PersonaDireccionDTO direccionDTO;
}