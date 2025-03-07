package ve.com.servicio.rest.DTO.response.clientes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * DTO para transporte de datos de respuesta para parametros
 * 
 * @author Jose Bustamante
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModeloRespClientes {

	private Integer id;
	private String nombre;
	private String apellido;
	private String tipoDoc;
	private String nroDoc;
	private String nroTelefono;
	private String email;
	private Integer estatus;
}