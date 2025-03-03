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
@Table(name = "compras_productos")
@Data
public class EntityComprasProducto {

	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "precio_unitario")
	private String precioUnitario;
	@Column(name = "cantidad")
	private String cantidad;
	@Column(name = "id_compra")
	private String idCompra;
}
