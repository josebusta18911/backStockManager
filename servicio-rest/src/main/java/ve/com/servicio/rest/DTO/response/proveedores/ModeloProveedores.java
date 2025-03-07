package ve.com.servicio.rest.DTO.response.proveedores;

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
   
public class ModeloProveedores {

	private Integer id;
	private String empresa;
	private String tipoProducto;
	private String nroTelefono;
	private String descripcion;
	private String email;
	private Integer estatus;
}
