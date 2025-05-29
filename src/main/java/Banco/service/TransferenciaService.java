package Banco.service;

import Banco.modelo.dto.TransferenciaDTO;
import Banco.modelo.entity.TransferenciaEntity;
import java.util.List;

public interface TransferenciaService {
    List<TransferenciaEntity> obtenerTodos();
    TransferenciaEntity obtenerPorId(Long id);
    TransferenciaEntity crear(TransferenciaDTO entity);
    TransferenciaEntity actualizar(Long id, TransferenciaDTO dto);
    void eliminar(Long id);
    List<TransferenciaEntity> obtenerPorIdTarjeta(Long idTarjeta);

}
