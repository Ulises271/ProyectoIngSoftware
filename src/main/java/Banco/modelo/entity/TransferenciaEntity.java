package Banco.modelo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity(name = "transferencias")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransferenciaEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransferencia;

    private Double monto;

    @Temporal(TemporalType.DATE)
    private Date fechaTransferencia;

    private String descripcion;

    // Tarjeta de origen (emisor)
    @ManyToOne
    @JoinColumn(name = "cuenta_origen_id")
    @JsonIgnore
    private TarjetasEntity cuentaOrigen;

    // Tarjeta de destino (receptor)
    @ManyToOne
    @JoinColumn(name = "cuenta_destino_id")
    @JsonIgnore
    private TarjetasEntity tarjetaDestino;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    @JsonIgnore
    private ClienteEntity cliente;
}
