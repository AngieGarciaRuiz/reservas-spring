package org.example.repaso01.dto.sala;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Data
@Builder
public class SalaResponseDTO {
    private Long id;
    private String nombre;
    private Integer capacidad;
    private String ubicacion;
    private String recursos;
    private boolean disponible;
}
