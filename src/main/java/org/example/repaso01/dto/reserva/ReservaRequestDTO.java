package org.example.repaso01.dto.reserva;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
public class ReservaRequestDTO {
    private LocalDate fechaReserva;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String motivo;
    private Long salaId;
    private Long usuarioId;
}
