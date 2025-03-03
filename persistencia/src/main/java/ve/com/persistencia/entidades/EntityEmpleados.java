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
@Table(name = "empleados")
@Data
public class EntityEmpleados {

	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellido")
	private String apellido;
	@Column(name = "ced_rif")
	private String cedRif;
	@Column(name = "fecha_nac")
	private String fechaNac;
	@Column(name = "direccion")
	private String direccion;
	@Column(name = "nro_telefono")
	private String nroTelefono;
	@Column(name = "email")
	private String email;
	@Column(name = "cargo")
	private String cargo;
	@Column(name = "fecha_ingreso")
	private String fechaIngreso;
	@Column(name = "salario")
	private String salario;
	@Column(name = "id_estatus")
	private String estatus;
}