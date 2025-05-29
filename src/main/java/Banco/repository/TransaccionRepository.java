package Banco.repository;

import Banco.modelo.entity.CuentaEntity;
import Banco.modelo.entity.TransaccionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransaccionRepository extends JpaRepository<TransaccionEntity, Long> {
    List<TransaccionEntity> findByCuenta_IdCuenta(Long idCuenta);
    List<TransaccionEntity> findByCuenta_Cliente_IdCliente(Long idCliente);

}
