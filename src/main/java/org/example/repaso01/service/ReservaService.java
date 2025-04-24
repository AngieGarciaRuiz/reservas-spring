package org.example.repaso01.service;

import org.example.repaso01.dto.reserva.ReservaRequestDTO;
import org.example.repaso01.dto.reserva.ReservaResponseDTO;
import org.example.repaso01.entity.Reserva;

import java.util.List;

public interface ReservaService {
    List<ReservaResponseDTO> listar();
    ReservaResponseDTO guardar(ReservaRequestDTO reservaRequestDTO);
    ReservaResponseDTO buscarReservaPorId(Long id);
    void borrarReserva(Long id);
}
