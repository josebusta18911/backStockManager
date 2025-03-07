package ve.com.negocio.usuario.modelo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;  

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModeloLlogin {
	private String rol;
	private String usuario;
	private Integer idEmpleado;
	private boolean acceso;

}
