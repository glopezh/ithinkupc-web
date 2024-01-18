package com.ithinkupc.web.dto;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
@EqualsAndHashCode(of={"id"})
public class RolPersonaDTO {
    private Long id;
    private Long persona;
    private Long rol;
}





