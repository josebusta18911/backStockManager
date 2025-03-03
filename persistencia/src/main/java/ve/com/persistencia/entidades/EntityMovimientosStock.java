package ve.com.persistencia.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 
 * Entidad para la tabla parametros
 * 
 * @author Jose Bustamante
 *
 */

@Entity
@Table(name = "movimientos_stock")
@Data
public class EntityMovimientosStock {

	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "id_producto")
	private String idProducto;
	@Column(name = "tipo_movimiento")
	private String tipoMovimiento;
	@Column(name = "cantidad")
	private String cantidad;
	@Column(name = "fecha")
	private String fecha;
}
