package Banco.repository;

import Banco.modelo.entity.ContactoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ContactoRepository extends JpaRepository<ContactoEntity, Long> {
    List<ContactoEntity> findByCliente_IdCliente(Long idCliente);
}
