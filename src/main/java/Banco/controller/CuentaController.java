package Banco.controller;

import Banco.modelo.entity.CuentaEntity;
import Banco.service.CuentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuentas")
@RequiredArgsConstructor
public class CuentaController {

    private final CuentaService cuentaService;

    // Obtener todas las cuentas
    @GetMapping
    public ResponseEntity<List<CuentaEntity>> obtenerTodasLasCuentas() {
        return ResponseEntity.ok(cuentaService.obtenerTodos());
    }

    // Obtener una cuenta por su ID
    @GetMapping("/{id}")
    public ResponseEntity<CuentaEntity> obtenerCuentaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cuentaService.obtenerPorId(id));
    }

    // Obtener cuentas por ID de cliente
    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<CuentaEntity>> obtenerCuentasPorCliente(@PathVariable Long idCliente) {
        return ResponseEntity.ok(cuentaService.obtenerPorIdCliente(idCliente));
    }

    // Crear una nueva cuenta
    @PostMapping
    public ResponseEntity<CuentaEntity> crearCuenta(@RequestBody CuentaEntity cuenta) {
        return ResponseEntity.ok(cuentaService.crear(cuenta));
    }

    // Actualizar una cuenta existente
    @PutMapping("/{id}")
    public ResponseEntity<CuentaEntity> actualizarCuenta(@PathVariable Long id, @RequestBody CuentaEntity cuenta) {
        return ResponseEntity.ok(cuentaService.actualizar(id, cuenta));
    }

    // Eliminar una cuenta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCuenta(@PathVariable Long id) {
        cuentaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
