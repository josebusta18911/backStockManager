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
	private Integer id;
	@Column(name = "id_proveedor")
	private Integer idProveedor;
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
	private Integer stock;
	@Column(name = "id_categoria")
	private Integer idCategoria;
	@Column(name = "id_compra")
	private Integer idCompra;
	@Column(name = "utilidad_porcentaje")
	private String utilidadPorcentaje;
	@Column(name = "id_estatus")
	private Integer estatus;
}