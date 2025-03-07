package ve.com.servicio.rest.DTO.request.estatus;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModeloReqEstatus {

	private Integer id;
	private String nombre;
	private String descripcion;
}
