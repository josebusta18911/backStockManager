package ve.com.persistencia.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModeloRespueta {
    private  Integer codigo;
    private   String primerNombre;
    private  String primerApellido;
    private String segundoNombre;
    private String segundoApellido;
    private  Integer estatus;
    private  String documentIdentidad;
    private String correo;
    private String telefono;
    private  String direccion;
    private  Integer idEmpleado;
    private String recursos;
    private String campaña;
    private String estado;
    private String codEmpl;
    private String dealer;
}
