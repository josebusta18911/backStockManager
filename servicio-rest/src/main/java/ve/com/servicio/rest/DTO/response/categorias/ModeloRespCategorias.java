package ve.com.servicio.rest.DTO.response.categorias;

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
public class ModeloRespCategorias {

	private Integer id;
	private String nombre;
	private String descripcion;
	private Integer estatus;

}