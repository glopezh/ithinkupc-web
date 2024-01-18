package com.ithinkupc.web.dto;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
@EqualsAndHashCode(of={"id"})
public class PersonaDireccionDTO {
    private Long id;
    private Long persona;
    private String tipoVia;
    private String nombreVia;
    private String ciudad;
}





