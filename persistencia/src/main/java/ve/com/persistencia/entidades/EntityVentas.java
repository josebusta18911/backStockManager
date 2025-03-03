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
@Table(name = "ventas")
@Data
public class EntityVentas {

	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "id_empleado")
	private String idEmpleado;
	@Column(name = "id_factura")
	private String idFactura;
	@Column(name = "id_estatus")
	private String estatus;
}