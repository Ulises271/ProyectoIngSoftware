package Banco.modelo.dto;

public class ContactosDTO {
    private Long id;
    private String nombre;
    private String telefono;
    private String correo;
    private Long clienteId;

    public ContactosDTO() {}

    public ContactosDTO(Long id, String nombre, String telefono, String correo, Long clienteId) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.clienteId = clienteId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
}
