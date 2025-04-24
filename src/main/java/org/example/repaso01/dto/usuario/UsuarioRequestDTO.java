package org.example.repaso01.dto.usuario;

import lombok.Data;

@Data
public class UsuarioRequestDTO {
    private String nombreCompleto;
    private String email;
    private String telefono;
    private String departamento;
}
