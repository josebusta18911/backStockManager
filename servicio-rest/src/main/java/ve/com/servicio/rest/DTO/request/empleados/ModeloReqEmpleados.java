package ve.com.servicio.rest.DTO.request.empleados;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModeloReqEmpleados {

	private Integer id;
	private String nombre;
	private String apellido;
	private String cedRif;
	private String fechaNac;
	private String direccion;
	private String nroTelefono;
	private String email;
	private String cargo;
	private String fechaIngreso;
	private String salario;
	private Integer estatus;
}
