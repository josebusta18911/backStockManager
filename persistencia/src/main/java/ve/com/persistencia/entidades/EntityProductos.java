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
@Table(name = "productos")
@Data
public class EntityProductos {

	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "id_proveedor")
	private String idProveedor;
	@Column(name = "codigo")
	private String codigo;
	@Column(name = "imagen")
	private String imagen;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "marca")
	private String marca;
	@Column(name = "precio_unidad")
	private String precioUnidad;
	@Column(name = "stock")
	private String stock;
	@Column(name = "id_categoria")
	private String idCategoria;
	@Column(name = "id_compra")
	private String idCompra;
	@Column(name = "utilidad_porcentaje")
	private String utilidadPorcentaje;
	@Column(name = "id_estatus")
	private String estatus;
}