package Banco.modelo.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RegistroClienteDTO {
    private String nombre;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String email;
    private String usuario;
    private String contrasena;
    private String fechaNacimiento; // Debe venir en formato "yyyy-MM-dd"
}
