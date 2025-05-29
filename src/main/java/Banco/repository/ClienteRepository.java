package Banco.repository;

import Banco.modelo.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

    // Buscar por correo (para login)
    Optional<ClienteEntity> findByEmail(String email);

    // También puedes dejar este si más adelante quieres permitir login por usuario
    Optional<ClienteEntity> findByUsuario(String usuario);
}
