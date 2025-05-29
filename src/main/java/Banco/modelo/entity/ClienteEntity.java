package Banco.modelo.entity;

import Banco.Enum.RolEnum;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteEntity {
    // En ClienteService.java


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente")
    private Long idCliente; // ✅ nombre de campo corregido

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "fechaNacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "contrasena")
    private String contrasena;

    @Column(name = "fechaRegistro")
    private LocalDate fechaRegistro;

    @Column(name = "ultimoAcceso")
    private LocalDateTime ultimoAcceso;

    @Column(name = "estado")
    private String estado;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol")
    private RolEnum rol;



}
