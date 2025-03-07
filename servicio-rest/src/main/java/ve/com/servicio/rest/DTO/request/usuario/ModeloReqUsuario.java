package ve.com.servicio.rest.DTO.request.usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor; 

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModeloReqUsuario {  

	private Integer id;
	private String usuario;
	private String password;
	private Integer idEmpleado;
	private Integer idRol;
	private String fechaCreacion;
	private String fechaActualizacion;
	private Integer estatus;
}
