 package ve.com.servicio.rest.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 
 * ENUM que contiene el codigo de respuesta, asi como el mensajee asociado a ese
 * codigo de respuesta.
 *
 * @author jos busaman
 */

@AllArgsConstructor
public enum EnumRespuesta {

	// Codigo Aprobado
	Aprobada("00", "Aprobado"),

	// Actualizar
	ConsultaParametrosInvalida("P1", "Se produjo un Error al intentar consultar Parametros, Comuniquese con sistemas"),

	// Estatus
	EstatusDataInvalida("E1", "Estatus no recuperable");

	// Atributos
	@Getter
	private String codigo;
	@Getter
	private String mensajeCliente;
}