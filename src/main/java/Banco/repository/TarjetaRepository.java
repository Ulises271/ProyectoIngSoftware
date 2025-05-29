package Banco.repository;

import Banco.modelo.entity.CuentaEntity;
import Banco.modelo.entity.TarjetasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarjetaRepository extends JpaRepository<TarjetasEntity, Long> {
    List<TarjetasEntity> findByCliente_IdCliente(Long idCliente);

}
