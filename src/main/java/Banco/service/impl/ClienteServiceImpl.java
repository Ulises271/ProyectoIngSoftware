package Banco.service.impl;

import Banco.Enum.RolEnum;
import Banco.modelo.dto.ClienteDTO;
import Banco.modelo.entity.ClienteEntity;
import Banco.repository.ClienteRepository;
import Banco.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteEntity> obtenerTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public ClienteEntity obtenerPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    @Override
    public ClienteEntity crear(ClienteDTO dto) {
        ClienteEntity cliente = new ClienteEntity();
        cliente.setNombre(dto.getNombre());
        cliente.setApellidos(dto.getApellidos());
        cliente.setTelefono(dto.getTelefono());

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fecha = LocalDate.parse(dto.getFechaNacimiento(), formatter);
            cliente.setFechaNacimiento(fecha);
        } catch (Exception e) {
            throw new RuntimeException("Formato de fecha inválido. Usa yyyy-MM-dd");
        }

        return clienteRepository.save(cliente);
    }

    @Override
    public ClienteEntity actualizar(Long id, ClienteDTO dto) {
        ClienteEntity cliente = obtenerPorId(id);
        cliente.setNombre(dto.getNombre());
        cliente.setApellidos(dto.getApellidos());
        cliente.setTelefono(dto.getTelefono());

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fecha = LocalDate.parse(dto.getFechaNacimiento(), formatter);
            cliente.setFechaNacimiento(fecha);
        } catch (Exception e) {
            throw new RuntimeException("Formato de fecha inválido. Usa yyyy-MM-dd");
        }

        return clienteRepository.save(cliente);
    }

    @Override
    public void eliminar(Long id) {
        clienteRepository.deleteById(id);
    }
    @Override
    public ClienteEntity registrarCliente(ClienteEntity cliente) {
        long totalClientes = clienteRepository.count();

        if (totalClientes == 0) {
            cliente.setRol(RolEnum.valueOf("ADMIN"));
        } else {
            cliente.setRol(RolEnum.valueOf("CLIENTE"));
        }

        return clienteRepository.save(cliente);
    }

}
