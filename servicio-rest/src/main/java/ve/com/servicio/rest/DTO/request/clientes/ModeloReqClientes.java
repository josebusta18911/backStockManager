package ve.com.servicio.rest.DTO.request.clientes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModeloReqClientes {

	private Integer id;
	private String nombre;
	private String apellido;
	private String tipoDoc;
	private String nroDoc;
	private String nroTelefono;
	private String email;
	private Integer estatus;
}
