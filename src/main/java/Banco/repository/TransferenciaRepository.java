package Banco.repository;

import Banco.modelo.entity.TransferenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferenciaRepository extends JpaRepository<TransferenciaEntity, Long> {

    List<TransferenciaEntity> findByCuentaOrigen_Cliente_IdCliente(Long idCliente);

    // ✅ Campo corregido de cuentaDestino a tarjetaDestino
    List<TransferenciaEntity> findByCuentaOrigen_IdTarjetaOrTarjetaDestino_IdTarjeta(Long cuentaOrigenId, Long cuentaDestinoId);
}
