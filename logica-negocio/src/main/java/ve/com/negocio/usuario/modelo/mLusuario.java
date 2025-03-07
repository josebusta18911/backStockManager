package ve.com.negocio.usuario.modelo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ve.com.persistencia.entidades.EntityUsuarios; 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class mLusuario {
	
	private Integer id;
	private String usuario;
	private String password;
	private String cedula;
	private String correo;
	private Integer telefono;
	private Integer nombreCompleto;
	private String idRol;
	private List<EntityUsuarios>  usuarios;
}
