package org.example.repaso01.dto.usuario;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioResponseDTO {
    private Long id;
    private String nombreCompleto;
    private String email;
    private String telefono;
    private String departamento;
}
