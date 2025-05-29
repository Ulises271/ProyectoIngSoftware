package Banco.service;

import Banco.modelo.dto.ContactosDTO;
import Banco.modelo.entity.ContactoEntity;
import java.util.List;

public interface ContactosService {
    List<ContactoEntity> obtenerTodos();
    ContactoEntity obtenerPorId(Long id);
    ContactoEntity crear(ContactosDTO entity);
    ContactoEntity actualizar(Long id, ContactosDTO entity);
    void eliminar(Long id);
    List<ContactoEntity> obtenerPorIdCliente(Long clienteId);
}
