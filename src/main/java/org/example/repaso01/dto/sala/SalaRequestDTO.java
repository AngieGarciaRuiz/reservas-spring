package org.example.repaso01.dto.sala;

import lombok.Data;

@Data
public class SalaRequestDTO {
    private String nombre;
    private Integer capacidad;
    private String ubicacion;
    private String recursos;
    private boolean disponible;
}
