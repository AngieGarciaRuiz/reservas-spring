package org.example.repaso01.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.repaso01.dto.sala.SalaRequestDTO;
import org.example.repaso01.dto.sala.SalaResponseDTO;
import org.example.repaso01.entity.Sala;
import org.example.repaso01.mapper.sala.SalaMapper;
import org.example.repaso01.repository.ISalaRepository;
import org.example.repaso01.service.SalaService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SalaServiceImpl implements SalaService {

    private final ISalaRepository salaRepository;
    private final SalaMapper salaMapper;

    @Override
    public List<SalaResponseDTO> listar() {
        return salaRepository.findAll().stream()
                .map(salaMapper::toSalaResponseDTO)
                .toList();
    }

    @Override
    public SalaResponseDTO guardar(SalaRequestDTO salaRequestDTO) {
        Sala sala = salaMapper.toEntity(salaRequestDTO);
        Sala salaGuardada = salaRepository.save(sala);
        return salaMapper.toSalaResponseDTO(salaGuardada);
    }

    @Override
    public SalaResponseDTO obtenerPorId(Long id) {
        return salaRepository.findById(id)
                .map(salaMapper::toSalaResponseDTO)
                .orElseThrow(() -> new RuntimeException("El usuario con id " + id + " no existe"));
    }

    @Override
    public void eliminar(Long id) {
        if (!salaRepository.existsById(id)) {
            throw new RuntimeException("El usuario no existe");
        }
        salaRepository.deleteById(id);
    }

    @Override
    public Sala obtenerEntidadPorId(Long id) {
        return salaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Sala no encontrada"));
    }
}
