package ve.com.servicio.rest.DTO.response.autenticacion;

 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ve.com.servicio.rest.DTO.response.ModeloRespBase; 

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ModeloRespLogin extends ModeloRespBase{
	private boolean acceso; 
	private String rol;
	private String usuario;
	private Integer idEmpleado;
}
