package Banco.modelo.dto;

import java.util.Date;

public class TarjetasDTO {
    private Long id;
    private String numero;
    private String tipo;
    private String fechaExpiracion;

    public TarjetasDTO() {}

    public TarjetasDTO(Long id, String numero, String tipo, String fechaExpiracion) {
        this.id = id;
        this.numero = numero;
        this.tipo = tipo;
        this.fechaExpiracion = fechaExpiracion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }
}
