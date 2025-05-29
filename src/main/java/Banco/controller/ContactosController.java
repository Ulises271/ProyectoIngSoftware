package Banco.controller;

import Banco.modelo.dto.ContactosDTO;
import Banco.modelo.entity.ContactoEntity;
import Banco.service.ContactosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contactos")
@RequiredArgsConstructor
public class ContactosController {

    private final ContactosService contactosService;

    // GET: Obtener todos los contactos
    @GetMapping
    public ResponseEntity<List<ContactoEntity>> obtenerTodos() {
        return ResponseEntity.ok(contactosService.obtenerTodos());
    }

    // GET: Obtener contacto por ID
    @GetMapping("/{id}")
    public ResponseEntity<ContactoEntity> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(contactosService.obtenerPorId(id));
    }

    // GET: Obtener contactos por ID del cliente
    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<ContactoEntity>> obtenerPorCliente(@PathVariable Long idCliente) {
        return ResponseEntity.ok(contactosService.obtenerPorIdCliente(idCliente));
    }

    // POST: Crear nuevo contacto
    @PostMapping
    public ResponseEntity<ContactoEntity> crear(@RequestBody ContactosDTO contactosDTO) {
        return ResponseEntity.ok(contactosService.crear(contactosDTO));
    }

    // PUT: Actualizar contacto existente
    @PutMapping("/{id}")
    public ResponseEntity<ContactoEntity> actualizar(@PathVariable Long id, @RequestBody ContactosDTO contactosDTO) {
        return ResponseEntity.ok(contactosService.actualizar(id, contactosDTO));
    }

    // DELETE: Eliminar contacto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        contactosService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
