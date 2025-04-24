package org.example.repaso01.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.repaso01.dto.reserva.ReservaRequestDTO;
import org.example.repaso01.dto.reserva.ReservaResponseDTO;
import org.example.repaso01.entity.Reserva;
import org.example.repaso01.entity.Sala;
import org.example.repaso01.entity.Usuario;
import org.example.repaso01.mapper.reserva.ReservaMapper;
import org.example.repaso01.mapper.sala.SalaMapper;
import org.example.repaso01.mapper.usuario.UsuarioMapper;
import org.example.repaso01.repository.IReservaRepository;
import org.example.repaso01.service.ReservaService;
import org.example.repaso01.service.SalaService;
import org.example.repaso01.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservaServiceImpl implements ReservaService {
    private final IReservaRepository reservaRepository;
    private final ReservaMapper reservaMapper;
    private final SalaService salaService;
    private final UsuarioService usuarioService;
    @Override
    public List<ReservaResponseDTO> listar() {
        return reservaRepository.findAll().stream()
                .map(reservaMapper::toDTO)
                .toList();
    }

    @Override
    public ReservaResponseDTO guardar(ReservaRequestDTO reservaRequestDTO) {
        Sala sala = salaService.obtenerEntidadPorId(reservaRequestDTO.getSalaId());
        Usuario usuario = usuarioService.obtenerEntidadPorId(reservaRequestDTO.getUsuarioId());
        boolean hayCruce = reservaRepository.existsBySalaAndFechaReservaAndHoraInicioLessThanAndHoraFinGreaterThan
                (sala, reservaRequestDTO.getFechaReserva()
                        , reservaRequestDTO.getHoraFin()
                        , reservaRequestDTO.getHoraFin());
        if(hayCruce){
            throw new RuntimeException("La sala ya esta reservada en este horario");
        }
        Reserva reserva = reservaMapper.toEntity(reservaRequestDTO,sala,usuario);
        Reserva reservaGuardada = reservaRepository.save(reserva);
        return reservaMapper.toDTO(reservaGuardada);
    }


    @Override
    public ReservaResponseDTO buscarReservaPorId(Long id) {
        return reservaRepository.findById(id)
                .map(reservaMapper::toDTO)
                .orElseThrow(()-> new RuntimeException("Reserva no encontrada"));
    }

    @Override
    public void borrarReserva(Long id) {
        if(!reservaRepository.existsById(id)){
            throw new RuntimeException("Reserva no encontrada");
        }
        reservaRepository.deleteById(id);
    }
}
