package com.ithinkupc.web.dto;
import lombok.*;

@ToString
@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
@EqualsAndHashCode(of={"id"})
public class RolDTO {
    private Long id;
    private String nombre;
    private RolPersonaDTO rolPersonaDTO;
}
