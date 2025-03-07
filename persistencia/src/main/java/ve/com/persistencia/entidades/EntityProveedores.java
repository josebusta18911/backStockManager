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
@Table(name = "proveedores")
@Data
public class EntityProveedores {

	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "empresa")
	private String empresa;
	@Column(name = "tipo_producto")
	private String tipoProducto;
	@Column(name = "nro_telefono")
	private String nroTelefono;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "email")
	private String email;
	@Column(name = "id_estatus")
	private Integer estatus;
}