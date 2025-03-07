package ve.com.servicio.rest.DTO.response.roles;

import lombok.AllArgsConstructor;
import lombok.Data; 
import lombok.NoArgsConstructor; 

/**
 * Modelo de respuesta base del servicio
 * 
 * @author Jose bustamante
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
   
public class ModeloRol {

	private Integer id;
	private String nombre; 
	private Integer estatus;
	private String descripcion;
}
