package Banco.modelo.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ClienteDTO {
    private Long id;
    private String nombre;
    private String apellidos;
    private String fechaNacimiento;
    private String telefono;

    public ClienteDTO() {}

    public ClienteDTO(Long id, String nombre, String apellidos, Date fechaNacimiento, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        if (fechaNacimiento != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            this.fechaNacimiento = formatter.format(fechaNacimiento);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}