package org.example.repaso01.service;

import org.example.repaso01.dto.usuario.UsuarioRequestDTO;
import org.example.repaso01.dto.usuario.UsuarioResponseDTO;
import org.example.repaso01.entity.Usuario;

import java.util.List;

public interface UsuarioService {
    List<UsuarioResponseDTO> listar();
    UsuarioResponseDTO guardar(UsuarioRequestDTO usuarioRequestDTO);
    UsuarioResponseDTO obtenerPorId(Long id);
    void eliminar(Long id);
    Usuario obtenerEntidadPorId(Long id);
}
