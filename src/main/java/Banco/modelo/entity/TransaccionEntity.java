package Banco.modelo.entity;

import Banco.Enum.TipoTransaccion;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transacciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransaccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransaccion;

    @ManyToOne
    @JoinColumn(name = "idCuenta", nullable = false)
    private CuentaEntity cuenta;

    @Enumerated(EnumType.STRING)
    private TipoTransaccion tipo;

    private BigDecimal monto;

    private String descripcion;

    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "id_tarjeta")
    @JsonIgnore
    private TarjetasEntity tarjeta;



    @ManyToOne
    @JoinColumn(name = "idCliente")
    @JsonIgnore
    private ClienteEntity cliente;

}
