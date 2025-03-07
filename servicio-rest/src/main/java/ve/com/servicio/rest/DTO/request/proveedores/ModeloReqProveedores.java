package ve.com.servicio.rest.DTO.request.proveedores;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModeloReqProveedores {

	private Integer id;
	private String empresa;
	private String tipoProducto;
	private String nroTelefono;
	private String descripcion;
	private String email;
	private Integer estatus;

}
