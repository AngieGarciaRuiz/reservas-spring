package org.example.repaso01.controller;

import lombok.RequiredArgsConstructor;
import org.example.repaso01.dto.reserva.ReservaRequestDTO;
import org.example.repaso01.dto.reserva.ReservaResponseDTO;
import org.example.repaso01.entity.Reserva;
import org.example.repaso01.service.ReservaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@RequiredArgsConstructor
public class ReservaController {
    private final ReservaService reservaService;
    @GetMapping("/listaReservas")
    public List<ReservaResponseDTO> listaReservas() {
        return reservaService.listar();
    }
    @PostMapping("/crearReservas")
    public ReservaResponseDTO crearReserva(@RequestBody ReservaRequestDTO reservaRequestDTO) {
        return reservaService.guardar(reservaRequestDTO);
    }
    @GetMapping("/{id}")
    public ReservaResponseDTO obtener(@PathVariable Long id){
        return reservaService.buscarReservaPorId(id);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        reservaService.borrarReserva(id);
    }
}
