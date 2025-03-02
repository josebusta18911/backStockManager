package ve.com.servicio.rest.DTO.response.parametros;

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
public class DTORespParametros {

	private String partipNombreParametro;
	private String partipDescripcion;
	private String pargrpId;
	private String partipValorDefecto;
	private String parvalValor;

}
