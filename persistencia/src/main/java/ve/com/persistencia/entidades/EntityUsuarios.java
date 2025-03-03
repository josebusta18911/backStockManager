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
public class EntityUsuarios {

	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "usuario")
	private String usuario;
	@Column(name = "password")
	private String password;
	@Column(name = "id_empleado")
	private String idEmpleado;
	@Column(name = "id_rol")
	private String idRol;
	@Column(name = "fecha_creacion")
	private String fechaCreacion;
	@Column(name = "fecha_actualizacion")
	private String fechaActualizacion;
	@Column(name = "id_estatus")
	private String estatus;
}