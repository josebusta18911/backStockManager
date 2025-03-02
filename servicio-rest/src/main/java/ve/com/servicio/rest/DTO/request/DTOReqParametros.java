package ve.com.servicio.rest.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * DTO para transporte de datos de entrada para parametros
 * 
 * @author Jose Bustamante
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOReqParametros {

	private String partipNombreParametro;
	private String partipDescripcion;
	private String pargrpId;
	private String partipValorDefecto;
	private String parvalValor;

}
