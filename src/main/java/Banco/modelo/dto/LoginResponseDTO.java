
package Banco.modelo.dto;

import Banco.Enum.RolEnum;
import lombok.Data;

@Data
public class LoginResponseDTO {
    private Long id;
    private String nombre;
    private String email;
    private RolEnum rol;
}
