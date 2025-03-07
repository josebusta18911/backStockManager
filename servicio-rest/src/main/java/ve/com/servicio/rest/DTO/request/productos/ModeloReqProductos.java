package ve.com.servicio.rest.DTO.request.productos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModeloReqProductos {

	private Integer id;
	private Integer idProveedor;
	private String codigo;
	private String imagen;
	private String nombre;
	private String marca;
	private String precioUnidad;
	private Integer stock;
	private Integer idCategoria;
	private Integer idCompra;
	private String utilidadPorcentaje;
	private Integer estatus;
}
