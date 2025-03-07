package ve.com.persistencia.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class modeloRespuestausuario {
	
	private Integer id;
	private String usuario;
	private String password;
	//private List<EntityUsuarios>  usuarios;
	private String fechaCreacion;
	private Integer estatus;
	private Integer idEmpleado;
	private Integer idRol;
	private String nombre;
}
