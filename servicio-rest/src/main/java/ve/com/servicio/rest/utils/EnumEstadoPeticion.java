 
package ve.com.servicio.rest.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 
 * Enumerador que cubre los estados sobre el cual una peticion recibida puede
 * estar
 * 
 * @author jos busaman
 *
 */
@AllArgsConstructor
public enum EnumEstadoPeticion {

	// Estados
	Registrada("REGISTRADA"), Procesando("PROCESANDO"), Completada("COMPLETADA");

	// Atributos
	@Getter
	private String estado;

}
