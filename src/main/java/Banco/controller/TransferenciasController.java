package Banco.controller;

import Banco.modelo.dto.TransferenciaDTO;
import Banco.modelo.entity.TransferenciaEntity;
import Banco.service.TransferenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transferencias")
@RequiredArgsConstructor
public class TransferenciasController {

    private final TransferenciaService transferenciasService;

    // GET: Obtener todas las transferencias
    @GetMapping
    public ResponseEntity<List<TransferenciaEntity>> obtenerTodas() {
        return ResponseEntity.ok(transferenciasService.obtenerTodos());
    }

    // GET: Obtener una transferencia por ID
    @GetMapping("/{id}")
    public ResponseEntity<TransferenciaEntity> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(transferenciasService.obtenerPorId(id));
    }

    // GET: Obtener transferencias por ID de tarjeta
    @GetMapping("/tarjeta/{idTarjeta}")
    public ResponseEntity<List<TransferenciaEntity>> obtenerPorTarjeta(@PathVariable Long idTarjeta) {
        return ResponseEntity.ok(transferenciasService.obtenerPorIdTarjeta(idTarjeta));
    }

    // POST: Crear una nueva transferencia
    @PostMapping
    public ResponseEntity<TransferenciaEntity> crear(@RequestBody TransferenciaDTO transferenciasDTO) {
        return ResponseEntity.ok(transferenciasService.crear(transferenciasDTO));
    }
}
