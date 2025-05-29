package Banco.service;

import Banco.modelo.entity.CuentaEntity;
import java.util.List;

public interface CuentaService {
    List<CuentaEntity> obtenerTodos();
    CuentaEntity obtenerPorId(Long id);
    CuentaEntity crear(CuentaEntity entity);
    CuentaEntity actualizar(Long id, CuentaEntity entity);
    void eliminar(Long id);
    List<CuentaEntity> obtenerPorIdCliente(Long clienteId);


}
