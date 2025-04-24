package org.example.repaso01.mapper.sala;

import org.example.repaso01.dto.sala.SalaRequestDTO;
import org.example.repaso01.dto.sala.SalaResponseDTO;
import org.example.repaso01.entity.Sala;
import org.springframework.stereotype.Component;

@Component
public class SalaMapper {
    public SalaResponseDTO toSalaResponseDTO(Sala sala) {
        return SalaResponseDTO.builder()
                .id(sala.getId())
                .nombre(sala.getNombre())
                .capacidad(sala.getCapacidad())
                .ubicacion(sala.getUbicacion())
                .recursos(sala.getRecursos())
                .disponible(sala.isDisponible())
                .build();
    }
    public Sala toEntity(SalaRequestDTO salaRequestDTO) {
        return Sala.builder()
                .nombre(salaRequestDTO.getNombre())
                .capacidad(salaRequestDTO.getCapacidad())
                .ubicacion(salaRequestDTO.getUbicacion())
                .recursos(salaRequestDTO.getRecursos())
                .disponible(salaRequestDTO.isDisponible())
                .build();
    }
}
