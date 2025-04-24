package org.example.repaso01.repository;

import org.example.repaso01.entity.Reserva;
import org.example.repaso01.entity.Sala;
import org.example.repaso01.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface IReservaRepository extends JpaRepository<Reserva, Long> {
    boolean existsBySalaAndFechaReservaAndHoraInicioLessThanAndHoraFinGreaterThan(
            Sala sala, LocalDate fecha, LocalTime horaFin, LocalTime horaInicio);
    List<Reserva> findByUsuario(Usuario usuario);
    List<Reserva> findBySala(Sala sala);
    List<Reserva> findByFechaReserva(LocalDate fecha);
}
