package Banco.service.impl;

import Banco.modelo.dto.TransferenciaDTO;
import Banco.modelo.entity.TarjetasEntity;
import Banco.modelo.entity.TransferenciaEntity;
import Banco.repository.TarjetaRepository;
import Banco.repository.TransferenciaRepository;
import Banco.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferenciaServiceImpl implements TransferenciaService {

    @Autowired
    private TransferenciaRepository repository;

    @Autowired
    private TarjetaRepository tarjetasRepository;

    @Override
    public List<TransferenciaEntity> obtenerTodos() {
        return repository.findAll();
    }

    @Override
    public TransferenciaEntity obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transferencia no encontrada"));
    }

    @Override
    public TransferenciaEntity crear(TransferenciaDTO dto) {
        TransferenciaEntity transferencia = new TransferenciaEntity();
        transferencia.setMonto(dto.getMonto());
        transferencia.setFechaTransferencia(dto.getFecha());

        if (dto.getCuentaOrigenId() != null) {
            TarjetasEntity origen = tarjetasRepository.findById(dto.getCuentaOrigenId())
                    .orElseThrow(() -> new RuntimeException("Tarjeta origen no encontrada"));
            transferencia.setCuentaOrigen(origen);
        }

        if (dto.getCuentaDestinoId() != null) {
            TarjetasEntity destino = tarjetasRepository.findById(dto.getCuentaDestinoId())
                    .orElseThrow(() -> new RuntimeException("Tarjeta destino no encontrada"));
            transferencia.setTarjetaDestino(destino); // ✅

        }

        return repository.save(transferencia);
    }

    @Override
    public TransferenciaEntity actualizar(Long id, TransferenciaDTO dto) {
        TransferenciaEntity existente = obtenerPorId(id);
        existente.setMonto(dto.getMonto());
        existente.setFechaTransferencia(dto.getFecha());

        if (dto.getCuentaOrigenId() != null) {
            TarjetasEntity origen = tarjetasRepository.findById(dto.getCuentaOrigenId())
                    .orElseThrow(() -> new RuntimeException("Tarjeta origen no encontrada"));
            existente.setCuentaOrigen(origen);
        }

        if (dto.getCuentaDestinoId() != null) {
            TarjetasEntity destino = tarjetasRepository.findById(dto.getCuentaDestinoId())
                    .orElseThrow(() -> new RuntimeException("Tarjeta destino no encontrada"));
            existente.setTarjetaDestino(destino);
        }

        return repository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<TransferenciaEntity> obtenerPorIdTarjeta(Long idTarjeta) {
        return repository.findByCuentaOrigen_IdTarjetaOrTarjetaDestino_IdTarjeta(idTarjeta, idTarjeta);
    }

}
