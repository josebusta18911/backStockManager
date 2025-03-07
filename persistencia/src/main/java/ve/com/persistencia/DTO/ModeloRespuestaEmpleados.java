package ve.com.persistencia.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModeloRespuestaEmpleados {

    private Integer id;
    private String codigo;
    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private String correo;
    private Integer nivel;
    private String fechaIngreso;
    private String fechaNacimiento;
    private Integer idsucursal;
    private Integer idCargo;
    private Integer estatus;
    private String rutaFoto;
    private String nombreSucursal;
    private String nombreCargo;
}
