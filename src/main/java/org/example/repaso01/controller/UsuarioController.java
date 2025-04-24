package org.example.repaso01.controller;

import lombok.RequiredArgsConstructor;
import org.example.repaso01.dto.usuario.UsuarioRequestDTO;
import org.example.repaso01.dto.usuario.UsuarioResponseDTO;
import org.example.repaso01.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;
    @GetMapping("ListarUsuarios")
    public List<UsuarioResponseDTO> listar(){
        return usuarioService.listar();
    }
    @PostMapping("CrearUsuarios")
    public UsuarioResponseDTO guardar(@RequestBody UsuarioRequestDTO usuarioRequestDTO){
        return usuarioService.guardar(usuarioRequestDTO);
    }
    @GetMapping("ListarUsuario/{id}")
    public UsuarioResponseDTO buscarPorId(@PathVariable Long id){
        return usuarioService.obtenerPorId(id);
    }
    @DeleteMapping("/{id}")
    public void eliminar (@PathVariable Long id){
        usuarioService.eliminar(id);
    }
}

