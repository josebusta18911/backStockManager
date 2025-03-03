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
@Table(name = "fallas_stock")
@Data
public class EntityFallasStock {

	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "id_producto")
	private String id_producto;
	@Column(name = "cantidad")
	private String cantidad;
	@Column(name = "fecha")
	private String fecha;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "id_estatus")
	private String estatus;
}