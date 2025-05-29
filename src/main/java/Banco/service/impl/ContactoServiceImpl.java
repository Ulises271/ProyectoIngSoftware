package Banco.service.impl;

import Banco.modelo.dto.ContactosDTO;
import Banco.modelo.entity.ClienteEntity;
import Banco.modelo.entity.ContactoEntity;
import Banco.repository.ContactoRepository;
import Banco.service.ContactosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoServiceImpl implements ContactosService {

    @Autowired
    private ContactoRepository contactoRepository;

    @Override
    public List<ContactoEntity> obtenerTodos() {
        return contactoRepository.findAll();
    }

    @Override
    public ContactoEntity obtenerPorId(Long id) {
        return contactoRepository.findById(id).orElse(null);
    }

    @Override
    public List<ContactoEntity> obtenerPorIdCliente(Long clienteId) {
        return contactoRepository.findByCliente_IdCliente(clienteId);
    }

    @Override
    public ContactoEntity crear(ContactosDTO dto) {
        ClienteEntity cliente = ClienteEntity.builder()
                .idCliente(dto.getClienteId())
                .build();

        ContactoEntity contacto = ContactoEntity.builder()
                .idContacto(dto.getId())
                .nombre(dto.getNombre())
                .telefono(dto.getTelefono())
                .email(dto.getCorreo())
                .cliente(cliente)
                .build();

        return contactoRepository.save(contacto);
    }

    @Override
    public ContactoEntity actualizar(Long id, ContactosDTO dto) {
        ContactoEntity contacto = obtenerPorId(id);
        if (contacto == null) return null;

        contacto.setNombre(dto.getNombre());
        contacto.setTelefono(dto.getTelefono());
        contacto.setEmail(dto.getCorreo());

        ClienteEntity cliente = ClienteEntity.builder()
                .idCliente(dto.getClienteId())
                .build();
        contacto.setCliente(cliente);

        return contactoRepository.save(contacto);
    }

    @Override
    public void eliminar(Long id) {
        contactoRepository.deleteById(id);
    }
}
