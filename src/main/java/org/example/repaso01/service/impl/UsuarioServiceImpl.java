package org.example.repaso01.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.repaso01.dto.usuario.UsuarioRequestDTO;
import org.example.repaso01.dto.usuario.UsuarioResponseDTO;
import org.example.repaso01.entity.Usuario;
import org.example.repaso01.mapper.usuario.UsuarioMapper;
import org.example.repaso01.repository.IUsuarioRepository;
import org.example.repaso01.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final IUsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public List<UsuarioResponseDTO> listar() {
        return usuarioRepository.findAll().stream()
               .map(usuarioMapper::toDto)
                .toList();
    }

    @Override
    public UsuarioResponseDTO guardar(UsuarioRequestDTO usuarioRequestDTO) {
        if(usuarioRepository.existsByEmail(usuarioRequestDTO.getEmail())) {
            throw new RuntimeException("El email ya esta registrado");
        }
        Usuario usuario = usuarioMapper.toEntity(usuarioRequestDTO);
        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        return usuarioMapper.toDto(usuarioGuardado);
    }

    @Override
    public UsuarioResponseDTO obtenerPorId(Long id) {
        return usuarioRepository.findById(id).map(usuarioMapper::toDto)
                .orElseThrow(() -> new RuntimeException("usuario no encontrado"));
    }

    @Override
    public void eliminar(Long id) {
        if(!usuarioRepository.existsById(id)) {
            throw new RuntimeException("El usuario con id " + id + " no existe");
        }
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario obtenerEntidadPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontro el usuario"));
    }
}
