package Banco.repository;

import Banco.modelo.entity.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CuentaRepository extends JpaRepository<CuentaEntity, Long> {

    // CORREGIDO: usa el nombre real del atributo en ClienteEntity
    List<CuentaEntity> findByCliente_IdCliente(Long idCliente);



    Optional<CuentaEntity> findByNumeroCuenta(String numeroCuenta);
}
