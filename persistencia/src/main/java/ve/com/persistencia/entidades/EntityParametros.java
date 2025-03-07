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
@Table(name = "parametros")
@Data
public class EntityParametros {

	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "valor")
	private String valor;
	@Column(name = "valor_defecto")
	private String valorDefecto;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "id_estatus")
	private Integer estatus;
}