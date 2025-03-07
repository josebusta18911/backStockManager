package ve.com.servicio.rest.DTO.request.rol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModeloReqRol {
	
	private Integer id;
	private String nombre; 
	private Integer estatus;
	private String descripcion;

}
