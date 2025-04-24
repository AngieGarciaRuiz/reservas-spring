package org.example.repaso01.mapper.usuario;

import org.example.repaso01.dto.usuario.UsuarioRequestDTO;
import org.example.repaso01.dto.usuario.UsuarioResponseDTO;
import org.example.repaso01.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    public UsuarioResponseDTO toDto(Usuario usuario) {
        return UsuarioResponseDTO.builder().id(usuario.getId()).nombreCompleto(usuario.getNombreCompleto())
                .email(usuario.getEmail()).telefono(usuario.getTelefono())
                .departamento(usuario.getDepartamento()).build();
    }
    public Usuario toEntity(UsuarioRequestDTO usuarioRequestDTO) {
        return Usuario.builder()
                .nombreCompleto(usuarioRequestDTO.getNombreCompleto())
                .email(usuarioRequestDTO.getEmail())
                .telefono(usuarioRequestDTO.getTelefono())
                .departamento(usuarioRequestDTO.getDepartamento())
                .build();
    }
}
