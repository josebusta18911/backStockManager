package ve.com.servicio.rest.DTO.response;

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
public class ModeloRespBase {

	// Atributos
	/** Codigo de respuesta generado por el servicio */
	private String codigo;

	/** Mensaje que se puede mostrar el cliente */
	private String mensajeCliente;

	/** Mensaje con detalle medio del codigo de respuesta */
	private String mensajeSistema;

}
