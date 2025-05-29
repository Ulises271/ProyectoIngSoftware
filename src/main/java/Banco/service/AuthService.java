package Banco.service;

import Banco.Enum.RolEnum;
import Banco.modelo.dto.LoginRequestDTO;
import Banco.modelo.dto.RegistroClienteDTO;
import Banco.modelo.entity.ClienteEntity;
import Banco.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class AuthService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteEntity login(LoginRequestDTO loginRequest) {
        System.out.println("📧 Email recibido: " + loginRequest.getEmail());
        System.out.println("🔐 Contraseña recibida: " + loginRequest.getContrasena());

        ClienteEntity cliente = clienteRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!cliente.getContrasena().equals(loginRequest.getContrasena())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        return cliente;
    }


    public ClienteEntity registrar(RegistroClienteDTO dto) {
        ClienteEntity cliente = new ClienteEntity();
        cliente.setNombre(dto.getNombre());
        cliente.setApellidos(dto.getApellidos());
        cliente.setDireccion(dto.getDireccion());
        cliente.setEmail(dto.getEmail());
        cliente.setUsuario(dto.getUsuario());
        cliente.setContrasena(dto.getContrasena());
        cliente.setTelefono(dto.getTelefono());

        // Convertir la fecha de nacimiento
        try {
            String rawDate = dto.getFechaNacimiento();
            // Intenta primero yyyy-MM-dd
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fechaNacimiento = LocalDate.parse(rawDate, formatter);
            cliente.setFechaNacimiento(fechaNacimiento);
        } catch (Exception e1) {
            try {
                // Intenta formato alternativo (por si acaso el navegador manda MM/dd/yyyy)
                DateTimeFormatter altFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                LocalDate fechaNacimiento = LocalDate.parse(dto.getFechaNacimiento(), altFormatter);
                cliente.setFechaNacimiento(fechaNacimiento);
            } catch (Exception e2) {
                throw new RuntimeException("Fecha de nacimiento inválida. Usa el formato yyyy-MM-dd");
            }
        }
        System.out.println("📆 Fecha de nacimiento recibida: " + dto.getFechaNacimiento());


        return registrarCliente(cliente);
    }

    public ClienteEntity registrarCliente(ClienteEntity cliente) {
        long total = clienteRepository.count();

        if (total == 0) {
            cliente.setRol(RolEnum.ADMIN); // Primer usuario: ADMIN
        } else {
            cliente.setRol(RolEnum.CLIENTE);
        }

        cliente.setFechaRegistro(LocalDate.now());
        return clienteRepository.save(cliente);
    }
}
