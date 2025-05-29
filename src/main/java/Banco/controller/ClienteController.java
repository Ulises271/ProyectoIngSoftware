package Banco.controller;

import Banco.modelo.dto.ClienteDTO;
import Banco.modelo.entity.ClienteEntity;
import Banco.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    // GET: Obtener todos los clientes
    @GetMapping
    public ResponseEntity<List<ClienteEntity>> obtenerTodos() {
        return ResponseEntity.ok(clienteService.obtenerTodos());
    }

    // GET: Obtener cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<ClienteEntity> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.obtenerPorId(id));
    }

    // POST: Crear nuevo cliente
    @PostMapping
    public ResponseEntity<ClienteEntity> crear(@RequestBody ClienteDTO clienteDTO) {
        return ResponseEntity.ok(clienteService.crear(clienteDTO));
    }

    // PUT: Actualizar cliente existente
    @PutMapping("/{id}")
    public ResponseEntity<ClienteEntity> actualizar(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        return ResponseEntity.ok(clienteService.actualizar(id, clienteDTO));
    }

    // DELETE: Eliminar o desactivar cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        clienteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
