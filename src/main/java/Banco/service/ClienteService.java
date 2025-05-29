package Banco.service;

import Banco.modelo.dto.ClienteDTO;
import Banco.modelo.entity.ClienteEntity;
import java.util.List;

public interface ClienteService {
    List<ClienteEntity> obtenerTodos();
    ClienteEntity obtenerPorId(Long id);
    ClienteEntity crear(ClienteDTO entity);
    ClienteEntity actualizar(Long id, ClienteDTO entity);
    void eliminar(Long id);

    ClienteEntity registrarCliente(ClienteEntity cliente);
}
