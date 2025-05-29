package Banco.service;

import Banco.modelo.dto.TarjetasDTO;
import Banco.modelo.entity.TarjetasEntity;
import java.util.List;

public interface TarjetasService {
    List<TarjetasEntity> obtenerTodos();
    TarjetasEntity obtenerPorId(Long id);
    TarjetasEntity crear(TarjetasDTO dto);
    TarjetasEntity actualizar(Long id, TarjetasDTO dto);

    void eliminar(Long id);
}
