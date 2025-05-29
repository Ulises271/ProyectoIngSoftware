package Banco.modelo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tarjetas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TarjetasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTarjeta;

    private String numeroTarjeta;
    private String tipoTarjeta;
    private Double saldo;

    private Date fechaEmision;
    private Date fechaExpiracion;

    @Enumerated(EnumType.STRING)
    private EstadoTarjeta estado;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    @JsonIgnore
    private ClienteEntity cliente;


    @OneToMany(mappedBy = "tarjetaDestino")
    @JsonIgnore
    private List<TransferenciaEntity> transferenciasDestino;


    @OneToMany(mappedBy = "cuentaOrigen") // ✅ nombre del atributo correcto
    @JsonIgnore
    private List<TransferenciaEntity> transferenciasOrigen;


    @OneToMany(mappedBy = "tarjeta")
    @JsonIgnore
    private List<TransaccionEntity> transacciones;

    public enum EstadoTarjeta {
        Activa, Bloqueada, Expirada
    }
}
