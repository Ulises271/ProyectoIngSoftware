
package Banco.controller;

import Banco.modelo.dto.LoginRequestDTO;
import Banco.modelo.dto.LoginResponseDTO;
import Banco.modelo.dto.RegistroClienteDTO;
import Banco.service.AuthService;
import Banco.modelo.entity.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> registrar(@RequestBody RegistroClienteDTO dto) {
        try {
            ClienteEntity registrado = authService.registrar(dto);
            return ResponseEntity.ok("Registro exitoso para: " + registrado.getNombre());
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Error al registrar: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO request) {
        try {
            ClienteEntity cliente = authService.login(request);

            LoginResponseDTO response = new LoginResponseDTO();
            response.setId(cliente.getIdCliente());
            response.setNombre(cliente.getNombre());
            response.setEmail(cliente.getEmail());
            response.setRol(cliente.getRol());

            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body("Credenciales inválidas: " + e.getMessage());
        }
    }

}
