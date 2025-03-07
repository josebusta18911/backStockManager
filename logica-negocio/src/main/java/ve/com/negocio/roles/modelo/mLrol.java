package ve.com.negocio.roles.modelo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ve.com.persistencia.entidades.EntityRoles; 

/**
 * POJO que representa la tabla de rol
 * 
 * @author Jose Bustamante
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class mLrol {
	
	private Integer id;
	private String nombre;
	private String descripcion;
	private String estatus;
	private String tipo;
	List<EntityRoles>  roles;
}
