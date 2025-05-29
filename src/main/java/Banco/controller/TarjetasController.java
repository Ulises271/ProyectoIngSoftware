package Banco.controller;

import Banco.modelo.dto.TarjetasDTO;
import Banco.modelo.entity.TarjetasEntity;
import Banco.service.TarjetasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/tarjetas")
@RequiredArgsConstructor
public class TarjetasController {

    private final TarjetasService tarjetasService;

    // GET: Obtener todas las tarjetas
    @GetMapping
    public ResponseEntity<List<TarjetasEntity>> obtenerTodas() {
        return ResponseEntity.ok(tarjetasService.obtenerTodos());
    }

    // GET: Obtener una tarjeta por ID
    @GetMapping("/{id}")
    public ResponseEntity<TarjetasEntity> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(tarjetasService.obtenerPorId(id));
    }

    // GET: Obtener tarjetas por ID del cliente
    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<TarjetasEntity>> obtenerPorCliente(@PathVariable Long idCliente) {
        return ResponseEntity.ok(Collections.singletonList(tarjetasService.obtenerPorId(idCliente)));
    }

    // POST: Crear nueva tarjeta
    @PostMapping
    public ResponseEntity<TarjetasEntity> crear(@RequestBody TarjetasDTO tarjetasDTO) {
        return ResponseEntity.ok(tarjetasService.crear(tarjetasDTO));
    }


    // PUT: Actualizar una tarjeta existente
    @PutMapping("/{id}")
    public ResponseEntity<TarjetasEntity> actualizar(@PathVariable Long id, @RequestBody TarjetasDTO tarjetaDTO) {
        return ResponseEntity.ok(tarjetasService.actualizar(id, tarjetaDTO));
    }

    // DELETE: Eliminar o desactivar una tarjeta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        tarjetasService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
