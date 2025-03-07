package ve.com.servicio.rest.DTO.request.categorias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModeloReqCategorias {

	private Integer id;
	private String nombre;
	private String descripcion;
	private Integer estatus;
}
