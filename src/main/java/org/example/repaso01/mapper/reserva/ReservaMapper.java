package org.example.repaso01.mapper.reserva;

import org.example.repaso01.dto.reserva.ReservaRequestDTO;
import org.example.repaso01.dto.reserva.ReservaResponseDTO;
import org.example.repaso01.entity.Reserva;
import org.example.repaso01.entity.Sala;
import org.example.repaso01.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class ReservaMapper {
    public ReservaResponseDTO toDTO(Reserva reserva) {
        return ReservaResponseDTO.builder()
                .id(reserva.getId())
                .fechaReserva(reserva.getFechaReserva())
                .horaInicio(reserva.getHoraInicio())
                .horaFin(reserva.getHoraFin())
                .motivo(reserva.getMotivo())
                .nombreSala(reserva.getSala().getNombre())
                .salaId(reserva.getSala().getId())
                .usuarioId(reserva.getUsuario().getId())
                .nombreUsuario(reserva.getUsuario().getNombreCompleto())
                .build();
    }
    public Reserva toEntity(ReservaRequestDTO reservaRequestDTO, Sala sala, Usuario usuario) {
        return Reserva.builder()
                .fechaReserva(reservaRequestDTO.getFechaReserva())
                .horaInicio(reservaRequestDTO.getHoraInicio())
                .horaFin(reservaRequestDTO.getHoraFin())
                .motivo(reservaRequestDTO.getMotivo())
                .sala(sala)
                .usuario(usuario)
                .build();
    }
}
