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
@Table(name = "usuarios")
@Data
public class EntityVentasProductos {

	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "id_venta")
	private String id_venta;
	@Column(name = "id_producto")
	private String id_producto;
	@Column(name = "cantidad")
	private String cantidad;
	@Column(name = "precio_unitario")
	private String precio_unitario;
	@Column(name = "utilidad")
	private String utilidad;
}