package Banco.modelo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "cuentas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CuentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCuenta;

    private String numeroCuenta;

    @Enumerated(EnumType.STRING)
    private EstadoCuenta estado;

    private Date fechaApertura;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    @JsonIgnore
    private ClienteEntity cliente;


    public enum EstadoCuenta {
        Activa, Inactiva
    }
}
