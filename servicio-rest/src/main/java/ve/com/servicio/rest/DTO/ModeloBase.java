package ve.com.servicio.rest.DTO;

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
@NoArgsConstructor
@AllArgsConstructor
public class ModeloBase {

	private String codigo;
	private String mensaje;

}
