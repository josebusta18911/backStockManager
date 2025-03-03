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
@Table(name = "clientes")
@Data
public class EntityClientes {
	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellido")
	private String apellido;
	@Column(name = "tipo_doc")
	private String tipo_doc;
	@Column(name = "nro_doc")
	private String nro_doc;
	@Column(name = "nro_telefono")
	private String nro_telefono;
	@Column(name = "email")
	private String email;
	@Column(name = "id_estatus")
	private String id_estatus;
}
