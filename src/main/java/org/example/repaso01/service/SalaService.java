package org.example.repaso01.service;

import org.example.repaso01.dto.sala.SalaRequestDTO;
import org.example.repaso01.dto.sala.SalaResponseDTO;
import org.example.repaso01.entity.Sala;

import java.util.List;

public interface SalaService {
    List<SalaResponseDTO> listar();
    SalaResponseDTO guardar(SalaRequestDTO salaRequestDTO);
    SalaResponseDTO obtenerPorId(Long id);
    void eliminar(Long id);
    Sala obtenerEntidadPorId(Long Id);
}
