package org.example.repaso01.controller;

import lombok.RequiredArgsConstructor;
import org.example.repaso01.dto.sala.SalaRequestDTO;
import org.example.repaso01.dto.sala.SalaResponseDTO;
import org.example.repaso01.service.ReservaService;
import org.example.repaso01.service.SalaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salas")
@RequiredArgsConstructor
public class SalaController {
    private final SalaService salaService;

    @GetMapping("ListarSalas")
    public List<SalaResponseDTO> listarSalas() {
        return salaService.listar();
    }
    @PostMapping("CrearSalas")
    public SalaResponseDTO crearSala(@RequestBody SalaRequestDTO salaRequestDTO) {
        return salaService.guardar(salaRequestDTO);
    }
    @GetMapping("/{id}")
    public SalaResponseDTO getSala(@RequestParam Long id){
        return salaService.obtenerPorId(id);
    }
    @DeleteMapping("/{id}")
    public void borrarSala(@PathVariable Long id){
        salaService.eliminar(id);
    }
}
