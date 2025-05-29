package Banco.modelo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "contactos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContacto;

    private String nombre;
    private String apellidos;
    private String alias;
    private String numeroCuenta;
    private String telefono;
    private String email;

    @ManyToOne
    @JoinColumn(name = "idCliente") // coincide con la base de datos
    private ClienteEntity cliente;
}
