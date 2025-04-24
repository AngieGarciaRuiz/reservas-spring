package org.example.repaso01.dto.reserva;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@Builder
public class ReservaResponseDTO {
    private Long id;
    private LocalDate fechaReserva;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String motivo;
    private Long salaId;
    private String nombreSala;
    private Long usuarioId;
    private String nombreUsuario;

}
