package Banco.controller;

import Banco.modelo.entity.ClienteEntity;
import Banco.repository.ClienteRepository;
import Banco.repository.CuentaRepository;
import Banco.repository.TarjetaRepository;
import Banco.repository.TransaccionRepository;
import Banco.repository.TransferenciaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController // Usamos @RestController para que devuelva JSON automáticamente
@RequestMapping("/api/user")
public class UserPanelController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private TarjetaRepository tarjetaRepository;

    @Autowired
    private TransaccionRepository transaccionRepository;

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    @GetMapping("/data")
    public ResponseEntity<?> getUserData(@RequestParam String email) {
        ClienteEntity cliente = clienteRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        Map<String, Object> data = new HashMap<>();
        data.put("cliente", cliente);
        data.put("cuentas", cuentaRepository.findByCliente_IdCliente(cliente.getIdCliente()));
        data.put("tarjetas", tarjetaRepository.findByCliente_IdCliente(cliente.getIdCliente()));
        data.put("transacciones", transaccionRepository.findByCuenta_Cliente_IdCliente(cliente.getIdCliente()));
        data.put("transferencias", transferenciaRepository.findByCuentaOrigen_Cliente_IdCliente(cliente.getIdCliente()));
        return ResponseEntity.ok(data);
    }
}
